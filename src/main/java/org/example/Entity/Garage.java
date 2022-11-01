package org.example.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String garageName;
private String isEmpty;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Car cars;

    public Garage(String garageName, String isEmpty) {
        this.garageName = garageName;
        this.isEmpty = isEmpty;
    }
}
