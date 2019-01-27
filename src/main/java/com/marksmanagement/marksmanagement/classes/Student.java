package com.marksmanagement.marksmanagement.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Students")
public class Student implements Serializable {
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "generator", initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private long ID;

    @Column(name = "Nume", nullable = false, unique = false)
    private String nume;

    @Column (name="Prenume", nullable = false, unique = false)
    private String prenume;

    @Column (name="Gen")
    private String gen;

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
