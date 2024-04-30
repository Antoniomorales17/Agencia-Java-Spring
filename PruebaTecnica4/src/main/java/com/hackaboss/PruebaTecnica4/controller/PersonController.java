package com.hackaboss.PruebaTecnica4.controller;

import com.hackaboss.PruebaTecnica4.dto.PersonUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Person;
import com.hackaboss.PruebaTecnica4.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/persons")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savePerson = personService.savePerson(person);
        if (savePerson != null) {
            return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> persons = personService.findAllPerson();
        if (!persons.isEmpty()) {
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Person> getPersonById(@PathVariable String dni) {
        Person person = personService.findPersonById(dni);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Person> updatePerson(@PathVariable String dni, @RequestBody PersonUpdateDto updatedPersonData) {
        Person updatedPerson = personService.updatePerson(dni, updatedPersonData);

        if (updatedPerson != null) {
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<String> deletePerson(@PathVariable String dni) {
        Person person = personService.deletePerson(dni);
        if (person != null) {
            return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }


}
