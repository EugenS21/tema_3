package com.marksmanagement.marksmanagement.services;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.repositories.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {
    @Autowired
    private ILessonRepository lessonRepository;
    public List<Lesson> getAllLessons(){
        return StreamSupport
                .stream(lessonRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
