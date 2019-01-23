package com.marksmanagement.marksmanagement.services;

import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    public List<Student> getAllStudents(){
        return StreamSupport
                .stream(iStudentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
