import { Component } from '@angular/core';
import { Product } from './app.product';
import { PRODUCTLIST } from './app.productslist';
import { ProductService } from './app.product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})

export class AppComponent {
  title = 'Product Lists';
  products = PRODUCTLIST;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.products = this.productService.getProducts();
  }
}