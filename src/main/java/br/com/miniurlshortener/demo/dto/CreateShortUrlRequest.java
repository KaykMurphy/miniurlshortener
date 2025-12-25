package br.com.miniurlshortener.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateShortUrlRequest (

        @NotBlank
        String originalUrl
){}