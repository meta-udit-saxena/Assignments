import { Component, OnInit } from '@angular/core';
import { Product } from '../product/product';
import { ProductService } from '../product/product.service';
@Component({
    selector: 'dashboard',
    templateUrl: './dashboard.html',
    styleUrls: ['./dashboard.css'],
})

export class DashboardComponent implements OnInit {
    products: Product[] = [];
    title = 'Top Products';
    constructor(private productService: ProductService) { }

    ngOnInit(): void {
        this.productService.getDashboard().then(products => this.products = products);
    }
}