package uk.co.gumtree;

import uk.co.gumtree.domain.Person;
import uk.co.gumtree.infrastructure.ConfigurationFactory;
import uk.co.gumtree.repository.PersonRepository;
import uk.co.gumtree.resource.AddressBookController;
import uk.co.gumtree.service.PersonService;

import java.io.IOException;
import java.util.List;

public class AddressBookUtility {

    public static void main(String args[]) {
        ConfigurationFactory configurationFactory = null;
        try {
            configurationFactory = new ConfigurationFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);
        AddressBookController addressBookController = new AddressBookController(personService, configurationFactory.getValue("inputFilePath"));
        List<Person> persons = addressBookController.getPersons();
        List<Person> maleFromAddressBook = addressBookController.getMales(persons);
        Person oldestPersonFromAddressBook = addressBookController.getOldestPerson(persons);
        long ageDifferenceInDays = addressBookController.getAgeDiffeence(persons, "Bill McKnight", "Paul Robinson");
    }
}
