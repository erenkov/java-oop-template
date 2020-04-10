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
        int lenghtSchoolBooksBeforeRemove = schoolBooks.length;
        schoolBooks = ArrayUtils.add(schoolBooks, new SchoolBook(book));
        return lenghtSchoolBooksBeforeRemove != schoolBooks.length;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] foundBooks = new SchoolBook[0];

        for (SchoolBook schoolBook : schoolBooks) {
            if (schoolBook.getName().equals(name)) {
                foundBooks = ArrayUtils.add(foundBooks, new SchoolBook(schoolBook));
            }
        }
        return foundBooks;
    }

    @Override
    public boolean removeByName(String name) {
        int lenghtSchoolBooksBeforeRemove = schoolBooks.length;
        schoolBooks = ArrayUtils.removeElements(schoolBooks, findByName(name));
        return lenghtSchoolBooksBeforeRemove != schoolBooks.length;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
