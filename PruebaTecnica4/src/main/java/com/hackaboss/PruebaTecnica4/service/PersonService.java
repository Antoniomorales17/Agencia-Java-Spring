package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.PersonUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Person;
import com.hackaboss.PruebaTecnica4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;


    /**
     * Guarda una persona en el repositorio.
     * Además de guardar la persona, este método también actualiza las asociaciones con las reservas de habitaciones y vuelos.
     *
     * @param person La persona que se va a guardar.
     * @return La persona guardada si se realiza con éxito, de lo contrario null.
     */
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


    /**
     * Actualiza los datos de una persona en el repositorio.
     *
     * @param dniPerson El DNI de la persona que se va a actualizar.
     * @param personDto El DTO que contiene los nuevos datos de la persona.
     * @return La persona actualizada si se realiza con éxito, de lo contrario null.
     */

    @Override
    public Person updatePerson(String dniPerson, PersonUpdateDto personDto) {
        Person existingPerson = personRepository.findById(dniPerson).orElse(null);

        if (existingPerson != null) {
            existingPerson.setName(personDto.getName());
            existingPerson.setLastName(personDto.getLastName());
            existingPerson.setEmail(personDto.getEmail());
            return personRepository.save(existingPerson);
        }
        return null;
    }

    @Override
    public Person deletePerson(String dni) {
        if (existingPerson(dni)) {
            Person person = personRepository.findById(dni).orElse(null);
            if (person != null) {
                personRepository.delete(person);
                return person;
            }
        }
        return null;
    }


    /**
     * Verifica si existe una persona con el DNI especificado.
     *
     * @param dni El DNI de la persona a verificar.
     * @return true si existe una persona con el DNI especificado, de lo contrario false.
     */

    private boolean existingPerson(String dni) {
        return personRepository.existsById(dni);
    }
}
