package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    public SimpleSchoolBookRepository() {
    }

    public SimpleSchoolBookRepository(SchoolBook[] schoolBooks) {
        this.schoolBooks = schoolBooks;
    }

    @Override
    public boolean save(SchoolBook book) {
        int lenghtSchoolBooksBeforeRemove = schoolBooks.length;         //Запоминаем длину массива до удаления
        /* В нов. массив большей длинны добавляем копию book (т.к. SchoolBook содержит только не изменяемые поля)*/
        schoolBooks = ArrayUtils.add(schoolBooks, new SchoolBook(book));
        return lenghtSchoolBooksBeforeRemove != schoolBooks.length;     //Если длина массива изменилась то true
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] foundBooks = new SchoolBook[0];        //Для массива найденных элементов

        for (SchoolBook schoolBook : schoolBooks) {                                     //Перебираем массив
            if (schoolBook.getName().equals(name)) {                                    //Если название совпадает, то
                foundBooks = ArrayUtils.add(foundBooks, new SchoolBook(schoolBook));    //Записываем в массив найденных
            }
        }
        return foundBooks;                                  //Возвращаем массив найденных
    }

    @Override
    public boolean removeByName(String name) {
        int lenghtSchoolBooksBeforeRemove = schoolBooks.length;         //Запоминаем длину массива до удаления
        /* Удаляем из массива schoolBooks элементы найденные по названию */
        schoolBooks = ArrayUtils.removeElements(schoolBooks, findByName(name));
        return lenghtSchoolBooksBeforeRemove != schoolBooks.length;     //Если длина массива изменилась то true
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
