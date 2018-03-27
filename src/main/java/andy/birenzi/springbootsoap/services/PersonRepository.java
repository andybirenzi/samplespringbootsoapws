package andy.birenzi.springbootsoap.services;

import io.andybirenzi.springbootsoap.Country;
import io.andybirenzi.springbootsoap.Currency;
import io.andybirenzi.springbootsoap.Person;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Component
public class PersonRepository {
    private static final Map<String, Person> persons = new HashMap<>();

    @PostConstruct
    public void initData() {
        Person jim = new Person();
        jim.setAge(45);
        jim.setFirstName("jim");
        jim.setLastName("kate");
        jim.setNationality("USA");

        persons.put(jim.getFirstName(), jim);

        Person kim = new Person();
        kim.setAge(67);
        kim.setFirstName("kim");
        kim.setLastName("Jate");
        kim.setNationality("CONGO");

        persons.put(kim.getFirstName(), kim);

        Person sim = new Person();
        sim.setAge(25);
        sim.setFirstName("Sim");
        sim.setLastName("Gate");
        sim.setNationality("Rwanda");

        persons.put(sim.getFirstName(), sim);
    }

    public Person findPerson(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return persons.get(name);
    }
}
