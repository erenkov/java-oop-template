package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author[] authors = new Author[0];

    public SimpleAuthorRepository() {
    }

    public SimpleAuthorRepository(Author[] authors) {
        this.authors = authors;
    }

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            authors = ArrayUtils.add(authors, new Author(author));
            return true;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author author : authors) {
            if (author.getName().equals(name) && author.getLastName().equals(lastname)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            authors = ArrayUtils.removeElement(authors, author);
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
