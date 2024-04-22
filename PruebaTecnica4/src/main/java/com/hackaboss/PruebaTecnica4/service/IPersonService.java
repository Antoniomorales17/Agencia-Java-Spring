package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.PersonUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Person;

import java.util.List;

public interface IPersonService {

    Person savePerson (Person person);
    List<Person> findAllPerson();
    Person findPersonById(String dni);
    Person updatePerson (String dniPerson, PersonUpdateDto personUpdateDto);

    Person deletePerson(String dni);
}
