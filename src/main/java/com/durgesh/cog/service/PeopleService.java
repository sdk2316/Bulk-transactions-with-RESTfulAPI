package com.durgesh.cog.service;

import java.util.List;

import com.durgesh.cog.model.Person;

public interface PeopleService {
    List<Person> findAllPeople();
    Person findById(long id);
    List<Person> findByIds(List<Long> id);

    Person insert(Person p);
    List<Person> insertAll(List<Person> p);

    boolean delete(Long id);
    boolean deleteAll(List<Person> ids);

    boolean update(Person p);
    boolean updateAll(List<Person> p);
}