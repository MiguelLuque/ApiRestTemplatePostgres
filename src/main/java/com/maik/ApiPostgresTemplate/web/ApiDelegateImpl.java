package com.maik.ApiPostgresTemplate.web;

import com.maik.ApiPostgresTemplate.api.BooksApiDelegate;
import com.maik.ApiPostgresTemplate.models.dto.BookDTO;
import com.maik.ApiPostgresTemplate.models.dto.TagDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiDelegateImpl implements BooksApiDelegate {

    @Override
    public ResponseEntity<Void> createBook(BookDTO body) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteBook(String bookId) {
        return BooksApiDelegate.super.deleteBook(bookId);
    }

    @Override
    public ResponseEntity<List<TagDTO>> findAllTags() {
        return BooksApiDelegate.super.findAllTags();
    }

    @Override
    public ResponseEntity<BookDTO> findBookById(String bookId) {
        return BooksApiDelegate.super.findBookById(bookId);
    }

    @Override
    public ResponseEntity<BookDTO> updateBook(BookDTO body) {
        return BooksApiDelegate.super.updateBook(body);
    }
}
