package br.com.miniurlshortener.demo.controller;

import br.com.miniurlshortener.demo.doc.UrlShortenerControllerSwaggerDoc;
import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.service.UrlShorteningService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>URL shortener Controller. Endpoints to:
 * <ul>
 *     <li>Create short URL.</li>
 *     <li>Redirect to original URL from shortCode of shortened URL.</li>
 * </ul>
 * @see br.com.miniurlshortener.demo.model.UrlEntity
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UrlShortenerController implements UrlShortenerControllerSwaggerDoc {

    private final UrlShorteningService urlShorteningService;

    /**
     * Create shorted URL from original URL.
     * @param request {@link CreateShortUrlRequest} containing original URL.
     * @return {@link ResponseEntity} containing shortCode of shortened URL.
     * @see CreateShortUrlRequest
     * @see CreateShortUrlResponse
     */
    @PostMapping("/shorten")
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody @Valid CreateShortUrlRequest request) {
        CreateShortUrlResponse response = urlShorteningService.createShortUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Redirect to original url from shortCode of shortened URL.
     * @param shortCode
     * @return {@link ResponseEntity} with redirect http status and Location header containing the original URL.
     * @throws br.com.miniurlshortener.demo.exception.UrlNotFoundException
     */
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode) {
        String originalUrl = urlShorteningService.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("Location", originalUrl)
                .build();
    }
}
