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
        int lenghtSchoolBooksBeforeRemove = authors.length;                    //Запоминаем длину массива до сохранения
        if (findByFullName(author.getName(), author.getLastName()) == null) {  //Поиск по имени - если не найден автор, то
            /* В нов. массив большей длинны добавляем копию author (т.к. Author содержит только не изменяемые поля)*/
            authors = ArrayUtils.add(authors, new Author(author));
        }
        return lenghtSchoolBooksBeforeRemove != authors.length;                 //Если длина массива изменилась то true
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author author : authors) {                                                     //Перебираем массив
            if (author.getName().equals(name) && author.getLastName().equals(lastname)) {   //Проверяем соответствие полного имени
                return author;                                                              //Возвращаем подходящий результат
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        int lenghtSchoolBooksBeforeRemove = authors.length;         //Запоминаем длину массива до удаления
        /* Удаляем из массива authors элемент найденный по полному имени */
        authors = ArrayUtils.removeElement(authors, findByFullName(author.getName(), author.getLastName()));
        return lenghtSchoolBooksBeforeRemove != authors.length;     //Если длина массива изменилась то true
    }

    @Override
    public int count() {
        return authors.length;
    }
}
