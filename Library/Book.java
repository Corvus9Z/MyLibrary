package com.howtodoinjava.hibernate.test.dto.Library;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name="ID",unique = true,nullable = false)
    private Integer bookID;
    @Column(name="Title",unique = true,nullable = false)
    private String title;

    @Column(name="Year Of Publication",nullable = false)
    private Integer yearOfPublication;
    @Column(name="Type",nullable = false)
    private String type;
    @Column(name="Number Of Pages",nullable = false)
    private Integer numberOfPages;
    @Column(name="Status",nullable = false)
    private boolean status;

    @OneToMany
    List<Author> authors;
    @OneToOne
    PublishingHouse publishingHouseBooks;
    @OneToMany List<ReviewAndStar> reviewAndStars;
    @OneToMany List<Person> personClients;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public PublishingHouse getPublishingHouseBooks() {
        return publishingHouseBooks;
    }

    public void setPublishingHouseBooks(PublishingHouse publishingHouseBooks) {
        this.publishingHouseBooks = publishingHouseBooks;
    }

    public List<ReviewAndStar> getReviewAndStars() {
        return reviewAndStars;
    }

    public void setReviewAndStars(List<ReviewAndStar> reviewAndStars) {
        this.reviewAndStars = reviewAndStars;
    }


    public List<Person> getPersonClients() {
        return personClients;
    }

    public void setPersonClients(List<Person> personClients) {
        this.personClients = personClients;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", type='" + type + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", status=" + status +
                ", authors=" + authors +
                ", publishingHouseBooks=" + publishingHouseBooks +
                ", reviewAndStars=" + reviewAndStars +
                ", personClients=" + personClients +
                '}';
    }
}
