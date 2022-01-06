import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Page } from './page';

@Injectable({
  providedIn: 'root'
})
export class PageService {
private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getPage(): Observable<Page[]> {
    return this.http.get<Page[]>(`${this.apiServerUrl}/page/all`);
  }

  public addPage(page: Page): Observable<Page> {
    return this.http.post<Page>(`${this.apiServerUrl}/page/add`, page);
  }

  public updatePage(page: Page): Observable<Page> {
    return this.http.put<Page>(`${this.apiServerUrl}/page/update`, page);
  }

  public deletePage(pageId: number): Observable<void> {
      return this.http.delete<void>(`${this.apiServerUrl}/page/delete/${pageId}`);
    }
}
