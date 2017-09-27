import { Component, OnInit } from '@angular/core';
import { Product } from '../product/product';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ProductService } from '../product/product.service';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
@Component
    ({
        selector: 'delete-product',
        templateUrl: './delete-product.html'
    })
export class DeleteProductComponent implements OnInit {
    products: Product[];
    product: Product;
    constructor(
        private productService: ProductService,
        private router: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.productService.getProducts().then(products => this.products = products);
        this.router.paramMap
            .switchMap((params: ParamMap) => this.productService
                .getProduct(+params.get('id')))
            .subscribe(product => this.product = product);
    }

    deleteProduct(): void {
        this.productService
            .deleteProduct(this.product.id)
            .then(() => {
                this.products = this.products.filter(p => p !== this.product);
            });
        this.goBack();
    }
    goBack(): void {
        this.location.back();
    }

}