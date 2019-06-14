package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Book {

  private Long id;
  private Long id_author;
  private String name;
  private Date published;

  public Long getId_author() {
    return id_author;
  }

  public void setId_author(Long id_author) {
    this.id_author = id_author;
  }

  public Date getPublished() {
    return published;
  }

  public void setPublished(Date published) {
    this.published = published;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", id_author=" + id_author +
            ", name='" + name + '\'' +
            ", published=" + published +
            '}';
  }
}