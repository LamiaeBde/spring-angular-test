import { Component, OnInit,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/article';
import { ArticleService } from 'src/app/services/article.service';
@Component({
  selector: 'app-addarticles',
  templateUrl: './addarticles.component.html',
  styleUrls: ['./addarticles.component.css']
})
export class AddarticlesComponent implements OnInit {

  article: Article = new Article();

  constructor(private articleService: ArticleService ,private router: Router) { }

  ngOnInit(): void {
  }

  addArticle() {
    this.articleService.addArticle(this.article).subscribe(
      data => {

              //console.log(data.picture.split("/")[data.picture.split("/").length-2])



        if (data != null) {
          this.router.navigateByUrl('/articles');
        }
      }
    )
  }


}
