package uk.co.gumtree.resource;


import uk.co.gumtree.businessobject.AgeBusinessObject;
import uk.co.gumtree.businessobject.GenderBusinessObject;
import uk.co.gumtree.domain.Person;
import uk.co.gumtree.service.PersonService;

import java.util.List;

public class AddressBookController {
    private final PersonService personService;
    private final String addressBookFile;

    public AddressBookController(PersonService personService, String addressBookFile) {

        this.personService = personService;
        this.addressBookFile = addressBookFile;
    }

    public List<Person> getPersons() {
        return personService.getPersons(addressBookFile);
    }

    public List<Person> getMales(List<Person> person) {
        personService.setBusinessObject(new GenderBusinessObject());
        return personService.getMales(person);
    }

    public Person getOldestPerson(List<Person> person) {
        personService.setBusinessObject(new AgeBusinessObject());
        return personService.getOldest(person).get(0);
    }

    public long getAgeDiffeence(List<Person> persons, String name1, String name2) {
        return personService.getAgeDifference(persons, name1, name2);
    }
}
