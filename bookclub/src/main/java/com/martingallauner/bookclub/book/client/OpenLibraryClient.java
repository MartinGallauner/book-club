package com.martingallauner.bookclub.book.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.martingallauner.bookclub.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@RequiredArgsConstructor
@Component
public class OpenLibraryClient {

    private final WebClient openLibraryWebClient;


    public Book fetchMetadataForBook(String isbn) {
        ObjectNode result = openLibraryWebClient.get().uri("/api/books",
                        uriBuilder -> uriBuilder.queryParam("jscmd", "data")
                                .queryParam("format", "json")
                                .queryParam("bibkeys", "ISBN:" + isbn)
                                .build())
                .retrieve()
                .bodyToMono(ObjectNode.class)
                .retryWhen(Retry.fixedDelay(2, Duration.ofMillis(200)))
                .block();

        JsonNode content = result.get("ISBN:" + isbn);

        return convertToBook(isbn, content);
    }

    private Book convertToBook(String isbn, JsonNode content) {
        Book book = new Book();
        book.setIsbn(isbn);

        if (content.hasNonNull("title")) {
            book.setTitle(content.get("title").asText());
        }

        if (content.hasNonNull("authors") && content.get("authors").get(0).hasNonNull("name")) {
            book.setAuthor(content.get("authors").get(0).get("name").asText());
        }

        if (content.hasNonNull("publishers") && content.get("publishers").get(0).hasNonNull("name")) {
            book.setPublisher(content.get("publishers").get(0).get("name").asText("n.A."));
        }

        if (content.hasNonNull("number_of_pages")) {
            book.setPages(content.get("number_of_pages").asLong(0));
        }

        book.setDescription(content.hasNonNull("notes") ? content.get("notes").asText("n.A.") : "n.A");

        if (content.hasNonNull("subjects") && content.get("subjects").get(0).hasNonNull("name")) {
            book.setGenre(content.get("subjects").get(0).get("name").asText("n.A."));
        } else {
            book.setGenre("n.A.");
        }

        return book;
    }


}
