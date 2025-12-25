package br.com.miniurlshortener.demo.controller;

import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.service.UrlShorteningService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private final UrlShorteningService urlShorteningService;


    @PostMapping("/shorten")
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody @Valid CreateShortUrlRequest request) {
        CreateShortUrlResponse response = urlShorteningService.createShortUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode) {
        String originalUrl = urlShorteningService.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", originalUrl)
                .build();
    }
}
