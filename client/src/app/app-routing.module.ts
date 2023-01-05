import { OrdersComponentComponent } from './components/ordersComponent/orders-component.component';
import { AddarticlesComponent } from './components/addarticlesComponent/addarticles.component';
import { ArticlesComponent } from './components/articlesComponent/articles.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'addarticles', component: AddarticlesComponent },
  { path: 'articles', component: ArticlesComponent },
  { path: 'orders', component: OrdersComponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
