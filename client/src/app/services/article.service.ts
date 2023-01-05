import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private _httpClient: HttpClient) { }

  private apiServerUrl = "http://localhost:8087/articles";

  public addArticle(article: Article): Observable<Article> {
    return this._httpClient.post<Article>(
      `${this.apiServerUrl}/articles`, article
    );
  }

  public getArticles(): Observable<Article[]> {
    return this._httpClient.get<Article[]>(`${this.apiServerUrl}/articles`);
  }
}
