package com.example.project_5.Repositries;

import com.example.project_5.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    Book findBookByName(String name);
    List<Book> findAllByGenre(String genre);
}
