package com.howtodoinjava.hibernate.test.dto.Library;

import jakarta.persistence.*;

@Entity
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue
    @Column(name="ID",unique = true,nullable = false)
    private Integer idAuthor;
    @Column(name="AuthorLastName",nullable = false)
    private String authorLastName;
    @Column(name="AuthorFirstName",nullable = false)
    private String authorFirstName;
    @Column(name="Age",nullable = false)
    private Integer age;
    @Column(name="Years of Experience",nullable = false)
    private Integer yearsOfExperience;
    @Column(name="Gender",nullable = false)
    private String gender;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", authorLastName='" + authorLastName + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", age=" + age +
                ", YearsOfExperience=" + yearsOfExperience +
                ", sex='" + gender + '\'' +
                '}';
    }
}
