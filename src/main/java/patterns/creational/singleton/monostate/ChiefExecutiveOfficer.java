package patterns.creational.singleton.monostate;

public class ChiefExecutiveOfficer {
    // monostate by making the members static
    // you can create as many Objects as you want but they will share the fields
    private static String name;
    private static String age;

    public String getName() {
        return ChiefExecutiveOfficer.name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }

    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Adam Smith");
        ceo.setAge("55");

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);
        // not really good, this class does not tell the user it is a singleton
        // how ever it behaves like one
    }
}
