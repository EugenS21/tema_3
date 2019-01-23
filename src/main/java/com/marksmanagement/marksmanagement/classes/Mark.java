package com.marksmanagement.marksmanagement.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Marks")
public class Mark implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private long ID;

    @Column(name="Mark", nullable = false, unique = false)
    private int nota;

    @ManyToOne
    @JoinColumn(name="ID_Student", referencedColumnName = "ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name="ID_Lectie",referencedColumnName = "ID")
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
