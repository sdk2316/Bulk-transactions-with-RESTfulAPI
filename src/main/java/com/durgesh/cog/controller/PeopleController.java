package com.durgesh.cog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.cog.model.Person;
import com.durgesh.cog.service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	private static final String REQUEST_NO_BODY = "Request does not contain a body";

    @Autowired
    PeopleService peopleService;

    @GetMapping("/")
    public List<Person> getAllPeople() {
        return peopleService.findAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable long id) {
        return peopleService.findById(id);
    }

    @PostMapping("")
    public String addPerson(@RequestBody Person person) {
        if(person != null) {
            peopleService.insert(person);
            return "Added a person";
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @PostMapping("bulk")
    public String addPeople(@RequestBody List<Person> people) {
        if(people != null && !people.isEmpty()) {
            peopleService.insertAll(people);
            return String.format("Added %d people.", people.size());
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") long id) {
        if(id > 0) {
            if(peopleService.delete(id)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The id is invalid for the person.";
    }

    @DeleteMapping("bulk")
    public String deletePeople(@RequestBody List<Person> ids) {
        if(!ids.isEmpty()) {
            if(peopleService.deleteAll(ids)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The request should contain a list of people to be deleted.";
    }

    @PutMapping("")
    public String updatePerson(@RequestBody Person person) {
        if(person != null) {
            peopleService.update(person);
            return "Updated person.";
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @PutMapping("bulk")
    public String updatePeople(@RequestBody List<Person> people) {
        if(people != null) {
            peopleService.updateAll(people);
            return "Updated people.";
        } else {
            return REQUEST_NO_BODY;
        }
    }
}