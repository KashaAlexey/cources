package by.cources.spring.task3.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Language{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
