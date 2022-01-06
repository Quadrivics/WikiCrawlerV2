package com.sergebosman.WikiCrawler.controller;

import com.sergebosman.WikiCrawler.model.Page;
import com.sergebosman.WikiCrawler.service.PageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Page>> getAllPages () {
        List<Page> pages = pageService.findAllPages();
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Page> getPageById (@PathVariable("id") Long id) {
        Page page = pageService.findPageById(id);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Page> addPage (@RequestBody Page page) {
        Page newPage = pageService.addPage(page);
        return new ResponseEntity<>(newPage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Page> updatePage(@RequestBody Page page) {
        Page updatePage = pageService.updatePage(page);
        return new ResponseEntity<>(updatePage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Page> deletePage(@PathVariable("id") Long id) {
        pageService.deletePage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
