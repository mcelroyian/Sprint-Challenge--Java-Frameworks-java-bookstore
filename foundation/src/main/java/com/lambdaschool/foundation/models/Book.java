package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @NotNull
    @Column(nullable = false)
    private String booktitle;

    @NotNull
    @Column(nullable = false, unique = true)
    private String ISBN;

    private int copy;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "book", allowSetters = true)
    private List<Wrote> wrotes = new ArrayList<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "section")
    @JoinColumn(name = "sectionid", nullable = false)
    private Section section;

    public Book() {
    }

    public Book(String booktitle, String ISBN, int copy, Section section) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.section = section;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Wrote> getWrotes() {
        return wrotes;
    }

    public void setWrotes(List<Wrote> wrotes) {
        for (Wrote wrote : wrotes)
        {
            wrote.setBook(this);
        }
        this.wrotes = wrotes;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", booktitle='" + booktitle + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", copy=" + copy +
                ", wrotes=" + wrotes +
                ", section=" + section +
                '}';
    }
}
