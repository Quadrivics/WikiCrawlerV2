package com.sergebosman.WikiCrawler.repository;

import com.sergebosman.WikiCrawler.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository <Page, Long> {
    void deletePageById(Long id);

    Optional<Page> findPageById(Long id);
}
