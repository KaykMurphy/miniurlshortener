package br.com.miniurlshortener.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity representing a shortened URL in the database.
 * <p>Table: {@code urls}</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String originalUrl;

    @Column(unique = true)
    private String shortCode;

    private LocalDateTime createdAt;


}
