import { Injectable } from '@angular/core';
import { Product } from './app.product';
import { PRODUCTLIST } from './app.productslist';

@Injectable()
export class ProductService {
    getProducts(): Product[] {
        return PRODUCTLIST;
    }
}