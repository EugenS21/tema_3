package com.marksmanagement.marksmanagement.repositories;

import com.marksmanagement.marksmanagement.classes.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILessonRepository extends CrudRepository<Lesson, Long> {
    public Iterable<Lesson> findAll();
    public Optional<Lesson> findById(Long lessonID);
}
