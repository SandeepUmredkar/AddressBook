package uk.co.gumtree.businessobject;

import uk.co.gumtree.domain.Person;

import java.util.List;

public interface BusinessObject {

    List<Person> filterObject(List<Person> persons, String criteria);
}
