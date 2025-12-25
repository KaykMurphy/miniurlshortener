package br.com.miniurlshortener.demo.service;

import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.exception.UrlNotFoundException;
import br.com.miniurlshortener.demo.model.UrlEntity;
import br.com.miniurlshortener.demo.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlShorteningServiceImpl implements UrlShorteningService {

    private final UrlRepository urlRepository;

    @Override
    public CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request) {

        String originalUrl = request.originalUrl();

        if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
            throw new IllegalArgumentException("URL deve começar com http:// ou https://");
        }

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder shortCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            shortCode.append(chars.charAt(random.nextInt(chars.length())));
        }

        String code = shortCode.toString();

        UrlEntity entity = new UrlEntity();
        entity.setOriginalUrl(request.originalUrl());
        entity.setShortCode(code);
        entity.setCreatedAt(LocalDateTime.now());

        urlRepository.save(entity);

        String shortUrl = "http://localhost:8080/api/" + code;

        return new CreateShortUrlResponse(
                shortUrl
        );
    }

    @Override
    public String getOriginalUrl(String shortCode) {

        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException("URL não encontrada"))
                .getOriginalUrl();
    }

}
