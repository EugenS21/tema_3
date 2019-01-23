package com.marksmanagement.marksmanagement.services;

import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.repositories.IMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MarkService {
    @Autowired
    private IMarkRepository iMarkRepository;
    public List<Mark> getAllMarks(){
        return StreamSupport
                .stream(iMarkRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addMark(){

    }
}
