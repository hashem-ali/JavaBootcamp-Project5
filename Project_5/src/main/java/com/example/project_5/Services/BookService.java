package com.example.project_5.Services;

import com.example.project_5.ApiExceptions.ApiException;
import com.example.project_5.Models.Book;
import com.example.project_5.Models.Store;
import com.example.project_5.Repositries.BookRepo;
import com.example.project_5.Repositries.StoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
//    private final Book book;
    private final BookRepo bookRepo;
    private final StoreRepo storeRepo;

    public List<Book> getBook() {
        return bookRepo.findAll();
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }

    public void updateBook(Integer id, Book book1){
        Book oldBook = bookRepo.getById(id);
        if(oldBook == null){
            throw new ApiException("Not found");
        }
        oldBook.setId(id);
        bookRepo.save(book1);
    }

    public void deleteBook(Integer id){
        Book oldBook = bookRepo.getById(id);
        if(oldBook == null){
            throw new ApiException("Not found");
        }
        bookRepo.deleteById(id);
    }

    public void assignStoreWithBook(Integer storeId, Integer bookId){
        Store store = storeRepo.getById(storeId);
        Book book = bookRepo.getById(bookId);
        if(book == null || store == null ){
            throw new ApiException("Not Found");
        }
        book.setStore(store);
        bookRepo.save(book);
    }
    public List<String> getAllBooksByStoreId(Integer storeId){
        Store store = storeRepo.getById(storeId);
        if(store == null){
            throw new ApiException("Not Found");
        }
        List<String> booksName = new ArrayList<>();
        for (Book book: store.getBooks())
        {
            booksName.add(book.getName());
        }
        return booksName;
    }

    public int numOfBooks(Integer bookId){
        Book book = bookRepo.getById(bookId);
        if(book == null){
            throw new ApiException("Not Found");
        }
        return book.getBookCount();
    }

    public Book getBookByName(String name){
    Book book = bookRepo.findBookByName(name);
    if(book == null){
        throw new ApiException("Not Found");
    }
    return book;
    }

    public List<Book> allBooksUnderGenre(String genre){
        return bookRepo.findAllByGenre(genre);
    }
}
