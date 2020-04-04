package com.tangbaobao.graphqlcurd.graphql.fetchers;

import com.tangbaobao.graphqlcurd.entity.Author;
import com.tangbaobao.graphqlcurd.service.AuthorService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author tangxuejun
 * @version 2020/4/4 10:00 下午
 */
@Component
public class AuthorFetcher {
    private final AuthorService authorService;

    public AuthorFetcher(AuthorService authorService) {
        this.authorService = authorService;
    }

    public DataFetcher<List<Author>> getAllAuthor() {
        return dataFetchingEnvironment -> authorService.getAllAuthor();
    }

    public DataFetcher<Author> authorById() {
        return dataFetchingEnvironment -> authorService.authorById(dataFetchingEnvironment.getArgument("id"));
    }

    public DataFetcher<Author> saveAuthor() {
        return dataFetchingEnvironment ->
                authorService.saveAuthor(this.mapLinkedMapToAuthor(dataFetchingEnvironment.getArgument("author")));
    }

    public DataFetcher<Boolean> deleteAuthor() {
        return dataFetchingEnvironment -> {
            authorService.deleteAuthorById(dataFetchingEnvironment.getArgument("id"));
            return true;
        };
    }

    private Author mapLinkedMapToAuthor(Map<String, String> mapping) {
        Author author = new Author();
        author.setCreatedTime(LocalDateTime.now());
        author.setUpdatedTime(LocalDateTime.now());
        author.setLastName(mapping.get("lastName"));
        author.setFirstName(mapping.get("firstName"));
        return author;
    }

}
