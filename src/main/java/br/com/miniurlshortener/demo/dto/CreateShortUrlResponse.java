package br.com.miniurlshortener.demo.dto;

/**
 * DTO containing full shortened URL.
 * @param shortUrl full shortened URL.
 */
public record CreateShortUrlResponse(

        String shortUrl
) {
}
