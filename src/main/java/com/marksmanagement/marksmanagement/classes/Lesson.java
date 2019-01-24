package com.marksmanagement.marksmanagement.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Lessons")
public class Lesson implements Serializable {
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "generator", initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long ID;

    @Column (name="Nume")
    private String nume;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
