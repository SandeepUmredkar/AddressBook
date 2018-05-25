package uk.co.gumtree.service;

import uk.co.gumtree.businessobject.BusinessObject;
import uk.co.gumtree.domain.Person;
import uk.co.gumtree.repository.PersonRepository;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


public class PersonService {
    private PersonRepository personRepository;
    private BusinessObject businessObject;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(String addressBookFile) {
        return personRepository.getPersons(addressBookFile);
    }

    public void setBusinessObject(BusinessObject businessObject) {
        this.businessObject = businessObject;
    }

    public List<Person> getMales(List<Person> persons) {
        return businessObject.filterObject(persons, "Male");
    }

    public List<Person> getOldest(List<Person> persons) {
        return businessObject.filterObject(persons, "old");
    }

    private Person getPerson(List<Person> persons, String name) {
        return personRepository.getPerson(persons, name);
    }

    public long getAgeDifference(List<Person> persons, String name1, String name2) {
        Person person1 = getPerson(persons, name1);
        Person person2 = getPerson(persons, name2);
        return DAYS.between(person1.birthDate, person2.birthDate);
    }


}
