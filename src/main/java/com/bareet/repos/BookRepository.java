package com.bareet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bareet.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
