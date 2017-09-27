import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ProductService } from '../product/product.service';
import { ProductDetailComponent } from '../product/product-details.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { ProductListComponent } from '../product/product-list.component';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';
import { AddProductComponent } from '../product/add-product.component';
import { UpdateProductComponent } from '../product/update-product.component';
import { ContactUsComponent } from '../contact-us/contact-us.component';
import { DeleteProductComponent } from '../product/delete-product.component';
import { ProductSearchComponent } from '../product/product-search.component';
@NgModule({
  declarations: [
    AppComponent,
    ProductDetailComponent,
    DashboardComponent,
    ProductListComponent,
    AddProductComponent,
    UpdateProductComponent,
    ContactUsComponent,
    DeleteProductComponent,
    ProductSearchComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    FormsModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
  ],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
