import { Component } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrderService } from 'src/app/services/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders-component',
  templateUrl: './orders-component.component.html',
  styleUrls: ['./orders-component.component.css']
})
export class OrdersComponentComponent {
  orders: Order[] = [];

  constructor(private orderService: OrderService,private router: Router) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders(): void {
    this.orderService.getOrders().subscribe(
      data => this.orders = data
    )
  }
deleteOrder(id_order: any) {
    this.orderService.deleteOrder(id_order).subscribe(
      data => {
        console.log('deleted response', data);
        this.getOrders();
      }
    )
  }
}
