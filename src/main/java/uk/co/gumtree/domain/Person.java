package uk.co.gumtree.domain;

import java.time.LocalDate;

public class Person {
    public String name;
    public String gender;
    public LocalDate birthDate;

    private Person(String name, String gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public static class PersonBuilder {
        private String name;
        private String gender;
        private LocalDate birthDate;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Person createPerson() {
            return new Person(name, gender, birthDate);
        }
    }
}
