package com.example.BookManagementSystem.Repository;

import com.example.BookManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
