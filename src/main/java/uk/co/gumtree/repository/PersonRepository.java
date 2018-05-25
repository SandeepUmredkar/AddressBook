package uk.co.gumtree.repository;

import uk.co.gumtree.domain.Person;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;

public class PersonRepository {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

    public PersonRepository() {

    }

    public List<Person> getPersons(String addressBookFile) {
        List<String> personStringEntry = null;
        try {
            personStringEntry = readLines(new File(addressBookFile), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Person> persons = new ArrayList<>();
        for (String person : personStringEntry) {
            String[] split = person.split(",");
            persons.add(new Person.PersonBuilder().name(split[0]).gender(split[1]).birthDate(LocalDate.parse(split[2], formatter)).createPerson());
        }
        return persons;

    }

    public Person getPerson(List<Person> persons, String name) {
        return persons.stream()
                .filter(c -> name.equals(c.name))
                .collect(Collectors.toList()).get(0);
    }
}
