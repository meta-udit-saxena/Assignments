import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product } from './product';
@Component({
    selector: 'product-list',
    templateUrl: './product-list.html',
    styleUrls: ['./product-list.css']
})

export class ProductListComponent implements OnInit {
    products: Product[];
    title = 'All Products';
    constructor(
        private productService: ProductService,
    ) { }

    ngOnInit(): void {
        this.getProducts();
    }

    getProducts(): void {
        this.productService.getProducts().then(products => this.products = products.slice(0));
    }

}