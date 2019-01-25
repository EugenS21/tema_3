package com.marksmanagement.marksmanagement.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="Marks")
public class Mark implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private long ID;

    @NotNull
    @Range(min = 1, max = 10)
    @Column(name="Mark", nullable = false, unique = false)
    private int nota;

    @ManyToOne
    @JoinColumn(name="ID_Student", referencedColumnName = "ID")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name="ID_Lectie",referencedColumnName = "ID")
    @JsonBackReference
    private Lesson lesson;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
