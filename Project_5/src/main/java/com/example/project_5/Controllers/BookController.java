package com.example.project_5.Controllers;

import com.example.project_5.Models.Book;
import com.example.project_5.Services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book/")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
//    private final Book book;
//
    @GetMapping("get")
    public ResponseEntity geBook()
    {
        List<Book> bookList = bookService.getBook();
        return ResponseEntity.status(200).body(bookList);
    }

    @PostMapping("add")
    public ResponseEntity addBook(@Valid @RequestBody Book book)
    {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added!");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book)
    {
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book updated!");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book delete!");
    }

    @PutMapping("/{bookId}/store/{storeId}")
    public ResponseEntity assignStoreWithBook(@PathVariable Integer bookId,@PathVariable Integer storeId)
    {
        bookService.assignStoreWithBook(bookId,storeId);
        return ResponseEntity.status(200).body("Store assigned with book");
    }
    @GetMapping("getAll/{storeId}")
    public ResponseEntity getAllBooksByStoreID(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(bookService.getAllBooksByStoreId(storeId));
    }
    @GetMapping("getBooks/{bookId}")
    public ResponseEntity getNumsOfBookById(@PathVariable Integer bookId ){
        return ResponseEntity.status(200).body(bookService.numOfBooks(bookId));
    }

    @GetMapping("getBookByName/{name}")
    public ResponseEntity getBookByName(@PathVariable String name){
        return ResponseEntity.status(200).body(bookService.getBookByName(name));
    }

    @GetMapping("getByGenre/{genre}")
    public ResponseEntity getAllByGenre(@PathVariable String genre){

        return ResponseEntity.status(200).body(bookService.allBooksUnderGenre(genre));
    }
}
