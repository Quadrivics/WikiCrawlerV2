package com.sergebosman.WikiCrawler.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Page implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String url;
    @Column(nullable = false, updatable = false)
    private String pageCode;

    public Page() {
    }

    public Page(Long id, String title, String url,  String pageCode) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.pageCode = pageCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
