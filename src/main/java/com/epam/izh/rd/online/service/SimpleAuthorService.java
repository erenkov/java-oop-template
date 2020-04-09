package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;

public class SimpleAuthorService implements AuthorService {
    private AuthorRepository authorRepository;

    public SimpleAuthorService() {
    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Метод должен сохранять автора.
     * По факту, он просто обращается к репозиторию с авторами и вызывает аналогичный метод, псоле чего возвращает результат.
     */
    @Override
    public boolean save(Author author) {
        return false;
    }

    /**
     * Метод должен находить автора по имени и фамилии.
     * По факту, он просто обращается к репозиторию с авторами и вызывает аналогичный метод, псоле чего возвращает результат.
     */
    @Override
    public Author findByFullName(String name, String lastname) {
        return null;
    }

    /**
     * Метод должен удалять автора.
     * По факту, он просто обращается к репозиторию с авторами и вызывает аналогичный метод, псоле чего возвращает результат..
     */
    @Override
    public boolean remove(Author author) {
        return false;
    }

    /**
     * Метод считать количество сохраненных авторов на текущий момент.
     * По факту, он просто обращается к репозиторию с авторами и вызывает аналогичный метод, псоле чего возвращает результат.
     */
    @Override
    public int count() {
        return 0;
    }
}
