package uk.co.gumtree.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.gumtree.businessobject.GenderBusinessObject;
import uk.co.gumtree.domain.Person;
import uk.co.gumtree.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PersonServiceSpecs {

    private PersonService personService;
    private PersonRepository mockPersonRepository = mock(PersonRepository.class);
    private GenderBusinessObject mockGenderBusinessObject = mock(GenderBusinessObject.class);

    @Before
    public void preActivities(){
        personService = new PersonService(mockPersonRepository);

    }

    @Test
    public void shouldMakeACallToPersonServiceAndGetPersonList(){
        //given
        List<Person> personList = new ArrayList<>();
        when(mockPersonRepository.getPersons("AddressBook.txt")).thenReturn(personList);

        //when
        List<Person> actualPersonList = personService.getPersons("AddressBook.txt");

        //then
        Assert.assertEquals(personList, actualPersonList);
    }

}