import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';

import { Router } from '@angular/router';
@Component({
    selector: 'add-product',
    templateUrl: './add-product.html'
})

export class AddProductComponent implements OnInit {
    products: Product[];
    constructor(
        private productService: ProductService,
        private route: Router) { }
    ngOnInit(): void {
        this.getProducts();
    }
    getProducts(): void {
        this.productService.getProducts().then(products => this.products = products);
    }
    addProduct(name: string, price: number): void {
        name = name.trim();
        if (!name) {
            return;
        }
        this.productService.createProduct(name, price)
            .then(product => {
                this.products.push(product);
            })
    }
}