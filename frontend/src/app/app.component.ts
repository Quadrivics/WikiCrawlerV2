import { Component, OnInit } from '@angular/core';
import { Page } from './page';
import { PageService } from './page.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'WikiCrawlerV2';

  public pages: Page[] = [];

  constructor(private pageService: PageService){}

  ngOnInit() {
    this.getPage();
  }

  public getPage(): void {
    this.pageService.getPage().subscribe(
    (response: Page[]) => {
    this.pages = response;
    console.log(this.pages);
    },
    (error: HttpErrorResponse) => {
    alert(error.message);
    });
  }

}
