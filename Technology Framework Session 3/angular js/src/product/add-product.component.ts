import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
@Component({
    selector: 'add-product',
    templateUrl: './add-product.html',
    styleUrls: ['./add-product.css']
})

export class AddProductComponent implements OnInit {
    products: Product[];
    constructor(
        private productService: ProductService,
        private route: Router,
        private location: Location
    ) { }
    ngOnInit(): void {
        this.getProducts();
    }
    getProducts(): void {
        this.productService.getProducts().then(products => this.products = products);
    }
    addProduct(name: string, price: number, imagePath: string, description: string, currency: string): void {
        name = name.trim();
        imagePath = imagePath.split('\\').pop();
        if (!name || !price || !imagePath || !description || !currency) {
            return;
        }
        this.productService.createProduct(name, price, imagePath, description, currency)
            .then(product => {
                this.products.push(product);
                this.location.back();
            })
      
    }
}