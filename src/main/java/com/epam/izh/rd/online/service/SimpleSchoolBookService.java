package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;

public class SimpleSchoolBookService implements BookService {
    private BookRepository<SchoolBook> schoolBookBookRepository = new SimpleSchoolBookRepository();
    private AuthorService authorService = new SimpleAuthorService();

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(Book book) {
        if (authorService.findByFullName( ((SchoolBook) book).getAuthorName(),
                                          ((SchoolBook) book).getAuthorLastName()) != null ) {
            schoolBookBookRepository.save((SchoolBook) book);
            return true;
        }
        return false;
    }

    @Override
    public Book[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        SchoolBook[] schoolBook = schoolBookBookRepository.findByName(name);
        return schoolBook.length;
    }

    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }

    @Override
    public Author findAuthorByBookName(String name) {
        Author author = authorService.findByFullName(schoolBookBookRepository.findByName(name)[0].getAuthorName(),
                                                     schoolBookBookRepository.findByName(name)[0].getAuthorLastName());
        return author;
    }
}
