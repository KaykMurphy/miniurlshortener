package br.com.miniurlshortener.demo.exception;

/**
 * Exception thrown when a requested short code is not found in the database.
 */
public class UrlNotFoundException extends RuntimeException {
    /**
     * Construct a new UrlNotFoundException with the specified detail message.
     * @param message the detail message explaining why the exception was thrown
     */
    public UrlNotFoundException(String message) {
        super(message);
    }
}
