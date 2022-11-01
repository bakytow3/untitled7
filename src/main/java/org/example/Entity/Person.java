package org.example.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Table(name = "persons")
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId ;
private String personName;
private int age;
private String email;
private String gender;
    @ManyToOne(cascade = {DETACH,REFRESH,MERGE,PERSIST},fetch = FetchType.LAZY)
    private Company compnanies;

    @OneToMany(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "persons")
    private List<Car> cars;

    public Person(String personName, int age, String email, String gender) {
        this.personName = personName;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }
}
