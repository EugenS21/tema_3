package com.marksmanagement.marksmanagement.repositories;

import com.marksmanagement.marksmanagement.classes.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarkRepository extends CrudRepository<Mark,Long> {
    Iterable<Mark> findAll();
    Iterable<Mark> findAllByStudentID(Long studentId);
    Iterable<Mark> findAllByLessonID(Long lessonId);
    Iterable<Mark> findAllByStudentIDAndLessonID(Long studentId, Long lessonId);

    Iterable<Mark> findAllByLessonIDAndStudentID(Long lessonId, Long studentId);
}
