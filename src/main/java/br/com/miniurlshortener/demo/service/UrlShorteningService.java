package br.com.miniurlshortener.demo.service;

import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShorteningService{
    CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request);

    String getOriginalUrl(String shortCode);
}
