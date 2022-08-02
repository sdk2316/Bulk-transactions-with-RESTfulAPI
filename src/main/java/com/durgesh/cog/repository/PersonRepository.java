package com.durgesh.cog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.cog.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
