package patterns.creational.builder;

public class DetailedPerson {
    public String streetAddress, postCode, city;
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "DetailedPerson{" +
            "streetAddress='" + streetAddress + '\'' +
            ", postCode='" + postCode + '\'' +
            ", city='" + city + '\'' +
            ", companyName='" + companyName + '\'' +
            ", position='" + position + '\'' +
            ", annualIncome=" + annualIncome +
            '}';
    }

    public static class PersonBuilder {
        protected DetailedPerson person = new DetailedPerson();

        public PersonAddressBuilder lives() {
            return new PersonAddressBuilder(person);
        }

        public PersonJobBuilder works() {
            return new PersonJobBuilder(person);
        }

        public DetailedPerson build() {
            return person;
        }
    }

    public static class PersonJobBuilder extends  PersonBuilder {
        public PersonJobBuilder(DetailedPerson person) {
            this.person = person;
        }
        public PersonJobBuilder at(String companyName) {
            person.companyName = companyName;
            return this;
        }

        public PersonJobBuilder asA(String position) {
            person.position = position;
            return this;
        }

        public PersonJobBuilder earning(int annualIncome) {
            person.annualIncome = annualIncome;
            return this;
        }
    }

    public static class PersonAddressBuilder extends PersonBuilder {
        public PersonAddressBuilder(DetailedPerson person) {
            this.person = person;
        }

        public PersonAddressBuilder at(String streetAddress) {
            person.streetAddress = streetAddress;
            return this;
        }
        public PersonAddressBuilder withPostCode(String postCode) {
            person.postCode = postCode;
            return this;
        }

        public PersonAddressBuilder in(String city) {
            person.city = city;
            return this;
        }
    }

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        DetailedPerson person = pb
            .lives()
            .at("123 London el dor el tany")
            .in("London")
            .withPostCode("201010")
            .works()
            .at("Company Name")
            .asA("Engineer")
            .earning(100)
            .build();
        System.out.println(person);
    }
}
