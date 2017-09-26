import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product } from './product';
import { ActivatedRoute, ParamMap } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import {DeleteProductComponent} from './delete-product.component';
@Component({
    selector: 'product-details',
    templateUrl: './product-details.html'
})

export class ProductDetailComponent implements OnInit {
    product: Product;
    constructor(
        private productService: ProductService,
        private route: ActivatedRoute
    ) { }

    ngOnInit(): void {
        this.route.paramMap
        .switchMap((params: ParamMap) => this.productService
            .getProduct(+params.get('id')))
        .subscribe(product => this.product = product);     
    }
}