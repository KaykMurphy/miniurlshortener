package br.com.miniurlshortener.demo.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO containing URL requested to short.
 * @param originalUrl
 */
public record CreateShortUrlRequest (

        @NotBlank
        String originalUrl
){}