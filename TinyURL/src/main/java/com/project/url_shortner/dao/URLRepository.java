package com.project.url_shortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.url_shortner.entity.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, Integer>{

    URL findFirstByOrderByIdDesc();
    URL findByShortURL(String shortUrl);

}
