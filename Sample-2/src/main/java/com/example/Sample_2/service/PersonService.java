package com.example.Sample_2.service;

import com.example.Sample_2.exception.ResourceNotExceptions;
import com.example.Sample_2.model.Person;
import com.example.Sample_2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person)
    {
        return personRepository.save(person);
    }

    public Person getPersonById(int id)
    {
        return personRepository.findById(id).orElseThrow(()->new ResourceNotExceptions("Person Not Found","id",id));
    }

    public Person updatePerson(int id,Person person)
    {
        Person persons = personRepository.findById(id).orElseThrow(()->new ResourceNotExceptions("Person Not Found","id",id));
        persons.setName(person.getName());
        persons.setAddress(person.getAddress());
        persons.setPhNo(persons.getPhNo());
        return personRepository.save(persons);
    }

    public void deletePerson(int id)
    {
        personRepository.deleteById(id);
    }

}
