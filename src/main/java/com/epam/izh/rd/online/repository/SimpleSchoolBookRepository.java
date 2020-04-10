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

    /**
     * Метод должен сохранять школьную книгу в массив schoolBooks.
     * Массив при каждом сохранении должен увеличиваться в размере ровно на 1.
     * То есть он ровно того размера, сколько сущностей мы в него сохранили.
     * <p>
     * Одну и ту же книгу МОЖНО сохранить в массиве несколько раз, проверки на то, что такая книга уже сохранена, делать не нужно.
     * <p>
     * Если сохранение прошло успешно, метод должен вернуть true.
     */
    @Override
    public boolean save(SchoolBook book) {

        schoolBooks = ArrayUtils.add(schoolBooks, new SchoolBook(book));
        return true;
    }

    /**
     * Метод должен находить в массиве schoolBooks все книги по имени.
     * <p>
     * Если книги найдены - метод должен их вернуть.
     * Если найденных по имени книг нет, должен вернуться пустой массив.
     */
    @Override
    public SchoolBook[] findByName(String name) {

        SchoolBook[] result = new SchoolBook[0];

        for (SchoolBook iterSchoolBook : schoolBooks) {
            if (iterSchoolBook.getName().equals(name)) {
                result = ArrayUtils.add(result, new SchoolBook(iterSchoolBook));
            }
        }
        return result;
    }

    /**
     * Метод должен удалять книги из массива schoolBooks по названию.
     * Если книг с одинаковым названием в массиве несколько, метод должен удалить их все.
     * <p>
     * Важно: при удалении книги из массива размер массива должен уменьшиться!
     * То есть, если мы сохранили 2 разные книги и вызвали count() (метод ниже), то он должен вернуть 2.
     * Если после этого мы удалили 1 книгу, метод count() должен вернуть 1.
     * <p>
     * Если хотя бы одна книга была найдена и удалена, метод должен вернуть true, в противном случае,
     * если книга не была найдена, метод должен вернуть false.
     */
    @Override
    public boolean removeByName(String name) {

        boolean result = false;
        SchoolBook[] tempSchoolBook = schoolBooks;

        schoolBooks=ArrayUtils.removeElements(schoolBooks, findByName(name));

//        for (SchoolBook schoolBook : schoolBooks) {
//            if (schoolBook.getName().equals(name)) {
//
//                if (tempSchoolBook.length == 1) {
//                    tempSchoolBook = new SchoolBook[0];
//                } else {
//                    tempSchoolBook = ArrayUtils.removeElement(schoolBooks, schoolBook);
//                }
//                result = true;
//            }
//        }

     //   schoolBooks = tempSchoolBook;

        return result;
    }

    /**
     * Метод возвращает количество сохраненных сущностей в массиве schoolBooks.
     */
    @Override
    public int count() {
        return schoolBooks.length;
    }
}
