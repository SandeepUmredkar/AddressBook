package uk.co.gumtree.businessobject;

import uk.co.gumtree.domain.Person;

import java.util.List;

public class AgeBusinessObject implements BusinessObject {

    @Override
    public List<Person> filterObject(List<Person> persons, String criteria) {
        persons.sort(new AgeComparator());
        return persons;
    }


}
