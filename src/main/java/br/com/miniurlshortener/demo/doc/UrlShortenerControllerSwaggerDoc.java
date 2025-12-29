package br.com.miniurlshortener.demo.doc;

import br.com.miniurlshortener.demo.dto.CreateShortUrlRequest;
import br.com.miniurlshortener.demo.dto.CreateShortUrlResponse;
import br.com.miniurlshortener.demo.controller.UrlShortenerController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface to document endpoints of {@link UrlShortenerController} using Spring OpenAPI (Swagger).
 * @author Filipe Martins
 */
public interface UrlShortenerControllerSwaggerDoc {

    @Operation(
            summary = "Create new shortened URL."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully create new short URL and register it on system",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = CreateShortUrlResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Intern Server Error",
                    content = @Content()
            ),
        }
    )
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody @Valid CreateShortUrlRequest request);


    @Operation(
            summary = "Redirect to the original URL",
            description = "Redirect to the original long URL from it shortCode"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "301",
                    description = "Successfully redirect to original URL",
                    headers = @Header(
                            name = "Location",
                            example = "http://host/vgsNc8"
                    ),
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Intern Server Error",
                    content = @Content()
            )
        }
    )
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode);
}
