package hm.daohibernate.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Persons implements Serializable{
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;

    private String phoneNumber;

    private String city;
}
