package org.example.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String companyName;
private String location;
    @ManyToOne(cascade = {MERGE, PERSIST, PERSIST, DETACH}, fetch = FetchType.EAGER)
    private Person person;

    public Company(String companyName, String location) {
        this.companyName = companyName;
        this.location = location;

    }
}
