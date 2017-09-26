import {Component,OnInit} from '@angular/core';
import { Product } from './product';
import {Location} from '@angular/common';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ProductService} from '../product/product.service';
@Component({
    selector:'update-product',
    templateUrl:'./update-product.html'
})

export class UpdateProductComponent{
    product:Product;
    constructor(
        private productService : ProductService,
        private route : ActivatedRoute,
        private location : Location
    ){}
    ngOnInit():void{
        this.route.paramMap
            .switchMap((params : ParamMap)=>this.productService.getProduct(+params.get('id')))
            .subscribe(product => this.product = product);
    }
    save():void{
        this.productService.updateProduct(this.product)
        .then(()=>this.goBack());
    }
    goBack():void
{
    this.location.back();
}}