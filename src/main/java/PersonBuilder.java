public class PersonBuilder {

    private String name;

    private String surname;
    private int age = -1;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 200) {
            throw new IllegalArgumentException("Недопустимый возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || name.isBlank() || surname == null || surname.isBlank()) {
            throw new IllegalStateException("Не указаны обязательные поля: Name,Surname");
        }

        person = (age != -1) ? new Person(name, surname, age) : new Person(name, surname);
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}
