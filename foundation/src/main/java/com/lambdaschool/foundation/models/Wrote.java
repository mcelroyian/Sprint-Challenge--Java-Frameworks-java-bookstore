package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "wrote",
uniqueConstraints = {@UniqueConstraint(columnNames = {"authorid", "bookid"})})
public class Wrote extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("wrotes")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    @JsonIgnoreProperties("wrotes")
    private Book book;

    public Wrote() {
    }

    public Wrote(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Wrote wrote = (Wrote) obj;
        return getAuthor().equals(wrote.getAuthor()) &&
                getBook().equals(wrote.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook(), getAuthor());
    }
}
