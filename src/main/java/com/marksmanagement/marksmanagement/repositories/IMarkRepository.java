package com.marksmanagement.marksmanagement.repositories;

import com.marksmanagement.marksmanagement.classes.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarkRepository extends CrudRepository<Mark,Long> {
    public Iterable<Mark> findAll();
    public Iterable<Mark> findBy();
}
