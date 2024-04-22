package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.PersonUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Person;
import com.hackaboss.PruebaTecnica4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements  IPersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person savePerson(Person person) {
        if (existingPerson(person.getDni())) {
            return null;
        }

        person.getRoomBookings().forEach(roomBooking -> roomBooking.getPersons().add(person));
        person.getFlightBookings().forEach(flightBooking -> flightBooking.getPersons().add(person));

        return personRepository.save(person);
    }


    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(String dni) {
        return personRepository.findById(dni).orElse(null);
    }

    @Override
    public Person updatePerson(String dniPerson, PersonUpdateDto personDto) {
        Person existingPerson = personRepository.findById(dniPerson).orElse(null);

        if (existingPerson != null){
            existingPerson.setName(personDto.getName());
            existingPerson.setLastName(personDto.getLastName());
            existingPerson.setEmail(personDto.getEmail());
            return personRepository.save(existingPerson);
        }
        return null;
    }

    @Override
    public Person deletePerson(String dni) {
        if (existingPerson(dni)){
            Person person = personRepository.findById(dni).orElse(null);
            if (person != null){
                personRepository.delete(person);
                return person;
            }
        }
        return null;
    }

    private boolean existingPerson(String dni){
        return personRepository.existsById(dni);
    }
}
