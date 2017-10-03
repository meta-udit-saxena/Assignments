import { Injectable } from '@angular/core';
import { Product } from './product';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private productsUrl = 'http://localhost:8080/layered-arch-1/service/product';

    constructor(private http: Http) { }

    getProducts(): Promise<Product[]> {
        const url = `${this.productsUrl}/list`;
        return this.http.get(url)
            .toPromise()
            .then(response =>
                response.json() as Product[])
            .catch(this.handleError);
    }

    getDashboard(): Promise<Product[]>{
        const url = `${this.productsUrl}/dashboard`;
        return this.http.get(url)
            .toPromise()
            .then(response=>
                response.json() as Product[])
            .catch(this.handleError);
    }
    getProduct(id: number): Promise<Product> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.get(url)
            .toPromise()
            .then(response => response.json() as Product)
            .catch(this.handleError);
    }

    deleteProduct(id: number): Promise<void> {
        const url = `${this.productsUrl}/${id}`;
        return this.http
            .delete(url, { headers: this.headers })
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }

    createProduct(name: string, price: number, imagePath: string, description: string, currency: string): Promise<Product> {
        const url = `${this.productsUrl}/add`;
        return this.http
            .post(url, JSON.stringify({ name: name, price: price, imagePath: imagePath, description: description, currency: currency }), { headers: this.headers })
            .toPromise()
            .then(res => res.json() as Product)
            .catch(this.handleError);
    }

    updateProduct(product: Product): Promise<Product> {
        const url = `${this.productsUrl}/update/${product.id}`;
        console.log(url);
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