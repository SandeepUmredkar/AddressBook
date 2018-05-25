package uk.co.gumtree.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.gumtree.domain.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonRepositorySpecs {

    private PersonRepository personRepository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

    @Before
    public void preActivities(){
        personRepository = new PersonRepository();

    }

    @Test
    public void shouldReadTheFileInPathAndReturnThePersonList(){
        //given
        List<Person> personList = new ArrayList<>();
        personList.add(new Person.PersonBuilder().name("Bill McKnight").gender("Male").birthDate(LocalDate.parse("16/03/77", formatter)).createPerson());
        personList.add(new Person.PersonBuilder().name("Paul Robinson").gender("Male").birthDate(LocalDate.parse("15/01/85", formatter)).createPerson());
        personList.add(new Person.PersonBuilder().name("Gemma Lane").gender("Female").birthDate(LocalDate.parse("20/11/91", formatter)).createPerson());
        personList.add(new Person.PersonBuilder().name("Sarah Stone").gender("Female").birthDate(LocalDate.parse("20/09/80", formatter)).createPerson());
        personList.add(new Person.PersonBuilder().name("Wes Jackson").gender("Male").birthDate(LocalDate.parse("14/08/74", formatter)).createPerson());

        //when
        List<Person> actualPersonList = personRepository.getPersons("/home/skywalker/projects/uk.gumtree/src/main/resources/AddressBook.txt");

        //then
        Assert.assertEquals(personList.get(0).name, actualPersonList.get(0).name);
        Assert.assertEquals(personList.get(0).gender, actualPersonList.get(0).gender);
        Assert.assertEquals(personList.get(0).birthDate, actualPersonList.get(0).birthDate);
        Assert.assertEquals(personList.get(1).name, actualPersonList.get(1).name);
        Assert.assertEquals(personList.get(1).gender, actualPersonList.get(1).gender);
        Assert.assertEquals(personList.get(1).birthDate, actualPersonList.get(1).birthDate);
        Assert.assertEquals(personList.get(2).name, actualPersonList.get(2).name);
        Assert.assertEquals(personList.get(2).gender, actualPersonList.get(2).gender);
        Assert.assertEquals(personList.get(2).birthDate, actualPersonList.get(2).birthDate);
        Assert.assertEquals(personList.get(3).name, actualPersonList.get(3).name);
        Assert.assertEquals(personList.get(3).gender, actualPersonList.get(3).gender);
        Assert.assertEquals(personList.get(3).birthDate, actualPersonList.get(3).birthDate);
        Assert.assertEquals(personList.get(4).name, actualPersonList.get(4).name);
        Assert.assertEquals(personList.get(4).gender, actualPersonList.get(4).gender);
        Assert.assertEquals(personList.get(4).birthDate, actualPersonList.get(4).birthDate);
    }
}