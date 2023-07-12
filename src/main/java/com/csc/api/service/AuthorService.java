package com.csc.api.service;

import com.csc.api.model.entity.Author;
import com.csc.api.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Integer AddNewAuthor(AuthorRequest authorRequest);

}
