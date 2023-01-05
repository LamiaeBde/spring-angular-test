import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/article';
import { Order } from 'src/app/models/order';
import { ArticleService } from 'src/app/services/article.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  order: Order = new Order();
  articles: Article[] = [];

  constructor(private articleService: ArticleService,
    private orderService: OrderService,
    private router: Router) { }

  ngOnInit(): void {
    this.getArticles();
  }

  getArticles(): void {
    this.articleService.getArticles().subscribe(
      data => this.articles = data
    )
  }

  addOrder(article: Article) {
    this.orderService.addOrder(this.order).subscribe(
      data => {
        console.log('response register', data);
        if (data != null) {
          this.orderService.AssignOrderToArticle(data.id_order, article.id_article).subscribe(
            data => data
          )
        }
        this.router.navigateByUrl('/orders');
      }
    )
  }

}
