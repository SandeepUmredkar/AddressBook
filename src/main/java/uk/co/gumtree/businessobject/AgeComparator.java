package uk.co.gumtree.businessobject;

import uk.co.gumtree.domain.Person;

import java.util.Comparator;

class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.birthDate.compareTo(p2.birthDate);
    }
}