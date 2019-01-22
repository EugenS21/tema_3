package com.marksmanagement.marksmanagement.repositories;

import com.marksmanagement.marksmanagement.classes.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {

}
