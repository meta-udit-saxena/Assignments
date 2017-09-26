import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { ProductSearchService } from './product-search.service';
import { Product } from './Product';

@Component({
  selector: 'product-search',
  templateUrl: './product-search.html',
  styleUrls:[
    './product-search.css'
  ],
  providers: [ProductSearchService]
})

export class ProductSearchComponent implements OnInit {
  products: Observable<Product[]>;
  private searchTerms = new Subject<string>();

  constructor(
    private ProductSearchService: ProductSearchService,
    private router: Router) {}

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.products = this.searchTerms  
      .distinctUntilChanged()
      .switchMap(term => term 
        ? this.ProductSearchService.search(term)
        : Observable.of<Product[]>([]))
      .catch(error => {
        console.log(error);
        return Observable.of<Product[]>([]);
      });
  }

  gotoDetail(Product: Product): void {
    let link = ['/details', Product.id];
    this.router.navigate(link);
  }
}