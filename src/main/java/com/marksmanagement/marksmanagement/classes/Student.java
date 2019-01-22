package com.marksmanagement.marksmanagement.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "generator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private long ID;

    @Column(name = "Nume", nullable = false, unique = false)
    private String nume;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
