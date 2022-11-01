package org.example.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String producedCountry;
    @ManyToOne(cascade = ALL,fetch = FetchType.LAZY)
    private Person persons;

    @OneToOne(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "cars")
    private Garage garage;


    public Car(String mark, String producedCountry) {
        this.mark = mark;
        this.producedCountry = producedCountry;
    }
}
