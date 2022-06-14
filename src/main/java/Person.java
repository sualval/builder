public class Person {

    private final String name;

    private final String surname;
    private int age = -1;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() throws IllegalArgumentException {
        if (hasAge()) {
            return age;
        }
        throw new IllegalArgumentException("Недопустимый возраст");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }

    @Override
    public String toString() {
        String checkAge = hasAge() ? ", age='" + age + '\'' : "";
        String checkAddress = address != null ? ", address='" + address + '\'' : "";

        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + checkAge + checkAddress + '}';
    }
}


