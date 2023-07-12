package com.csc.api.service.serviceImp;

import com.csc.api.model.entity.Author;
import com.csc.api.model.request.AuthorRequest;
import com.csc.api.repository.AuthorRepository;
import com.csc.api.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceIpm implements AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorServiceIpm(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthor();
    }

    @Override
    public Integer AddNewAuthor(AuthorRequest authorRequest) {
      Integer  authorId= authorRepository.saveAuthor(authorRequest);
        return authorId;
    }


}
