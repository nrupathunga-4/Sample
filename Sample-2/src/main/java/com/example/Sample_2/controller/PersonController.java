package com.example.Sample_2.controller;

import com.example.Sample_2.model.Person;
import com.example.Sample_2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(name = "id") int id)
    {
        return new ResponseEntity<>(personService.getPersonById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(name = "id") int id,@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.updatePerson(id,person),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id")  int id)
    {
        personService.deletePerson(id);
        return new ResponseEntity<>("Person Deleted From DataBase",HttpStatus.OK);
    }

}
