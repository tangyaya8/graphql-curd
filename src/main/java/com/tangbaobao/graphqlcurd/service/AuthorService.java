package com.tangbaobao.graphqlcurd.service;

import com.tangbaobao.graphqlcurd.entity.Author;
import com.tangbaobao.graphqlcurd.repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangxuejun
 * @version 2020/4/4 9:20 下午
 */
@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

    public Author authorById(Long id) {
        return authorRepo.getOne(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }

}
