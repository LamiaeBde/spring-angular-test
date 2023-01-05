import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private _httpClient: HttpClient) { }

  private apiServerUrl = "http://localhost:8087/articles";

  public addOrder(order: Order): Observable<Order> {
    order.date = new Date();
    return this._httpClient.post<Order>(
      `${this.apiServerUrl}/orders`, order
    );
  }
public deleteOrder(id_order: any): Observable<any> {
    return this._httpClient.delete<any>(`${this.apiServerUrl}/delete/` + id_order , {});
  }

  public AssignOrderToArticle(id_order: any, id_article: any): Observable<any> {
    return this._httpClient.put<any>(`${this.apiServerUrl}/orders/` + id_order + "/article/" + id_article, {});
  }

  public getOrders(): Observable<Order[]> {
    return this._httpClient.get<Order[]>(`${this.apiServerUrl}/orders`);
  }
}
