/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8test;

import com.java8test.TestInterface;
import com.java8test.entity.Person;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author slozic
 */
public class Java8Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TestInterface t1 = message -> System.out.println("Message: " + message);
        t1.printMessage("poruka");

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        int count = (int) strings.parallelStream().filter(string
            -> string.isEmpty()).count();

        List<String> filtered = strings.parallelStream().filter(string
            -> string.isEmpty()).collect(Collectors.toList());

        TestInterface t2 = messages
            -> ((List<String>) messages).forEach(System.out::println);

        t1.printMessage(count);
        t2.printMessage(filtered);

        List<Person> list1 = Person.createShortList();

        // Define Western and Eastern Lambdas
        Function<Person, String> westernStyle = p -> {
            return "\nName: " + p.getGivenName() + " " + p.getSurName() + "\n"
                + "Age: " + p.getAge() + "  " + "Gender: " + "\n"
                + "EMail: " + p.geteMail() + "\n"
                + "Phone: " + p.getPhone() + "\n"
                + "Address: " + p.getAddress();
        };

        Function<Person, String> easternStyle = p -> "\nName: " + p.getSurName() + " "
            + p.getGivenName() + "\n" + "Age: " + p.getAge() + "  "
            + "Gender: " + "\n"
            + "EMail: " + p.geteMail() + "\n"
            + "Phone: " + p.getPhone() + "\n"
            + "Address: " + p.getAddress();

        // Print Western List
        System.out.println("\n===Western List===");
        list1.forEach(System.out::println);

        // Print Eastern List
        System.out.println("\n===Eastern List===");
        for (Person person : list1) {
            System.out.println(
                person.printCustom(easternStyle)
            );
        }

    }

}
