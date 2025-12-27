package br.com.miniurlshortener.demo.service;

import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Service for URL shortening operations.
 *
 * <p>Handles creations of shortened URLs and retrieval of original URLs from shortCode.</p>
 */
public interface UrlShorteningService{
    /**
     * Create shortened URL from original.
     * @param request {@link CreateShortUrlRequest} with the long original URL
     * @return {@link CreateShortUrlResponse} with the full shortened URL
     */
    CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request);

    /**
     * Retrieval original URL from it shortCode
     * @param shortCode {@link String} with the shortCode
     * @return {@link String} with the long original URL
     */
    String getOriginalUrl(String shortCode);
}
