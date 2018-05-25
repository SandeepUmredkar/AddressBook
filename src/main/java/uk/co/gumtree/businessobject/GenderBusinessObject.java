package uk.co.gumtree.businessobject;

import uk.co.gumtree.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class GenderBusinessObject implements BusinessObject {

    @Override
    public List<Person> filterObject(List<Person> persons, String criteria) {
        return persons.stream()
                .filter(c -> "Male".equals(c.gender))
                .collect(Collectors.toList());
    }
}
