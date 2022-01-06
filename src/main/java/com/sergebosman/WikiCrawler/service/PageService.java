package com.sergebosman.WikiCrawler.service;

import com.sergebosman.WikiCrawler.exception.PageNotFoundException;
import com.sergebosman.WikiCrawler.model.Page;
import com.sergebosman.WikiCrawler.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PageService {
    private final PageRepository pageRepository;

    @Autowired
    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Page addPage(Page page) {
        page.setPageCode(UUID.randomUUID().toString());
        return pageRepository.save(page);
    }

    public List<Page> findAllPages() {
        return pageRepository.findAll();
    }

    public Page updatePage(Page page) {
        return pageRepository.save(page);
    }

    public Page findPageById(Long id) {
        return pageRepository.findPageById(id)
                .orElseThrow(() -> new PageNotFoundException("Page by id " + id + " was not found"));
    }

    public void deletePage(Long id) {
        pageRepository.deletePageById(id);
    }
}
