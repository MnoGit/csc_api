package com.csc.api.controller;

import com.csc.api.model.entity.Author;
import com.csc.api.model.request.AuthorRequest;
import com.csc.api.model.response.AuthorResponse;
import com.csc.api.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@SecurityRequirement(name = "bearer")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    @Operation(summary =  "Get all authors")
    public ResponseEntity <AuthorResponse<List<Author>>> getAllAuthors(){
        AuthorResponse<List<Author>> response = AuthorResponse.<List<Author>>builder()
                .message("Successfull")
                .payload(authorService.getAllAuthors())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    @Operation(summary = "addNew author")
    public ResponseEntity<AuthorResponse<Author>> addNewAuthor(@RequestBody AuthorRequest authorRequest){
        if(authorService.AddNewAuthor(authorRequest) != null){
            AuthorResponse<Author> response = AuthorResponse.<Author>builder()
                    .message("Add success")
//                    .payload(authorService.re)
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;
    }
    @GetMapping("/admin")
        public String getAdminPage(){
        return "Hello admin";
        }
    @GetMapping("/user")
    public String getUserPage(){
        return "Hello user";
    }

}
