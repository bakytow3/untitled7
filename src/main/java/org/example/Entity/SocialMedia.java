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
@NoArgsConstructor
@Table

public class SocialMedia {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String socialMedia;
    @ManyToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST}, fetch = FetchType.LAZY)
    List<Person> personList = new ArrayList<>();

    public SocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }
}
