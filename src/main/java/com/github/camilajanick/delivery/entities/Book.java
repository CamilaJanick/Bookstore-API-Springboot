package com.github.camilajanick.delivery.entities;

import com.github.camilajanick.delivery.entities.enums.ReadingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "books_table")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private String gender;

    private Integer totalPages;
    private Integer readPages;

    private Integer status;
    private Boolean favorite;

    public Book() {
    }

    public Book(Long id, String name, String author, String gender, Integer totalPages, Integer readPages, ReadingStatus status, Boolean favorite) {
        super();

        this.id = id;
        this.name = name;
        this.author = author;
        this.gender = gender;
        this.totalPages = totalPages;
        this.readPages = readPages;

        setReadingStatus(status);

        this.favorite = favorite;
    }

    public ReadingStatus getReadingStatus(){
        return ReadingStatus.valueOf(status);
    }

    public void setReadingStatus(ReadingStatus status) {
        if (status != null){
            this.status = status.getCode();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getReadPages() {
        return readPages;
    }

    public void setReadPages(Integer readPages) {
        this.readPages = readPages;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
