import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductDetailComponent } from '../product/product-details.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { ProductListComponent } from '../product/product-list.component';
import {UpdateProductComponent} from '../product/update-product.component';
import {ContactUsComponent} from '../contact-us/contact-us.component';
import {AddProductComponent} from '../product/add-product.component';
const routes: Routes = [
  {
    path: 'products',
    component: ProductDetailComponent
  },
  {
    path: 'details/:id',
    component: ProductDetailComponent
  },
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'productList',
    component: ProductListComponent
  },
  {
    path: 'update/:id',
    component: UpdateProductComponent
  },
  {
    path: 'contact-us',
    component: ContactUsComponent
  },
  {
    path : 'add-product',
    component:AddProductComponent
  }
  
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}