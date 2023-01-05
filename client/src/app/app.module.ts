
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticlesComponent } from './components/articlesComponent/articles.component';
import { AddarticlesComponent } from './components/addarticlesComponent/addarticles.component';
import { OrdersComponentComponent } from './components/ordersComponent/orders-component.component';
import { NavbarComponentComponent } from './components/navbar-component/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    AddarticlesComponent,
    NavbarComponentComponent,
    OrdersComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
