package com.marksmanagement.marksmanagement.repositories;

import com.marksmanagement.marksmanagement.classes.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonRepository extends CrudRepository<Lesson, Long> {

}
