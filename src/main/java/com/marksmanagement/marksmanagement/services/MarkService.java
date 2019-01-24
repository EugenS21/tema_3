package com.marksmanagement.marksmanagement.services;

import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.repositories.IMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MarkService {
    @Autowired
    private IMarkRepository markRepository;
    public List<Mark> getAllMarks(){
        return StreamSupport
                .stream(markRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Mark addMark(final Mark mark){
        return markRepository.save(mark);
    }

    public List<Mark> getMarkByLessonID(Long lessonID){
        return StreamSupport
                .stream(markRepository.findAllByLessonID(lessonID).spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Mark> getMarkByStudentID(Long studentID) {
        return StreamSupport
                .stream(markRepository.findAllByStudentID(studentID).spliterator(), false)
                .collect(Collectors.toList());
    }

//    public Optional<Mark> getMarksForStudentsAndLessons(Long studentId,
//                                                      Long lessonId )
//    {
//        Iterator<Mark> iterator = markRepository.findAllByStudentIdAndLessonId( studentId, lessonId ).iterator( );
//
//        Mark mark = null;
//        if( iterator.hasNext( ) )
//        {
//            mark = iterator.next( );
//        }
//
//        return Optional.ofNullable( mark );
//    }

}
