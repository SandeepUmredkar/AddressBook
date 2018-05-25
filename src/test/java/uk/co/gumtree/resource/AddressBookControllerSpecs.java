package uk.co.gumtree.resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.gumtree.domain.Person;
import uk.co.gumtree.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookControllerSpecs {
    private AddressBookController addressBookController;
    private PersonService mockPersonService = mock(PersonService.class);

    @Before
    public void preActivities(){
        String addressBookFile = "AddressBook.txt";
        addressBookController = new AddressBookController(mockPersonService, addressBookFile);

    }

    @Test
    public void shouldMakeACallToAddressBookControllerAndGetPersonList(){
        //given
        List<Person> personList = new ArrayList<>();
        when(mockPersonService.getPersons("AddressBook.txt")).thenReturn(personList);

        //when
        List<Person> actualPersonList = addressBookController.getPersons();

        //then
        Assert.assertEquals(personList, actualPersonList);
    }

}
