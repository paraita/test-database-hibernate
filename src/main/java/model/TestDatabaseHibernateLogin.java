package model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "LOGIN")
@Data
@Builder
public class TestDatabaseHibernateLogin {

    @GeneratedValue
    @Id
    @Column(name = "TOTO_ID")
    Long loginId;

    String userName;

    int age;

    String nom;

    String prenom;

}
