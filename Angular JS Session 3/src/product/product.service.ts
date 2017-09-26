import { Injectable } from '@angular/core';
import { Product } from './product';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private productsUrl = 'api/PRODUCTLIST';

    constructor(private http: Http) { }

    getProducts(): Promise<Product[]> {
        return this.http.get(this.productsUrl)
            .toPromise()
            .then(response => 
                response.json().data as Product[])
            .catch(this.handleError);
    }
    getProduct(id: number): Promise<Product> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.get(url)
            .toPromise()
            .then(response => response.json().data as Product)
            .catch(this.handleError);
    }

    deleteProduct(id: number): Promise<void> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.delete(url, { headers: this.headers })
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }

    createProduct(name: string, price: Number): Promise<Product> {
        return this.http
            .post(this.productsUrl, JSON.stringify({ name: name, price: price }), { headers: this.headers })
            .toPromise()
            .then(res => res.json().data as Product)
            .catch(this.handleError);
    }

    updateProduct(product: Product): Promise<Product> {
        const url = `${this.productsUrl}/${product.id}`;
        return this.http
            .put(url, JSON.stringify(product), { headers: this.headers })
            .toPromise()
            .then(() => product)
            .catch(this.handleError);
    }
    private handleError(error: any): Promise<any> {
        console.error('An error occured', error);
        return Promise.reject(error.message || error);
    }
}