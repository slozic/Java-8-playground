/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8test;

import com.java8test.SimpleInterface;
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
        t2.test();

        List<Person> listPersons = Person.createShortList();

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
        listPersons.forEach(System.out::println);

        // Print Eastern List
        System.out.println("\n===Eastern List===");
        for (Person person : listPersons) {
            System.out.println(
                person.printCustom(easternStyle)
            );
        }
        
        filter(Arrays.asList("simple","mike check"), (String s) -> System.out.println(s));
        filter(Arrays.asList("method reference",""), (String s) -> metoda(s));
        filter(Arrays.asList("complicated","word"), new SimpleOne());
        filter(listPersons, (Person p) -> System.out.println(p.printCustom(easternStyle)));
        
    }

    public static <T> void filter(List<T> lista, SimpleInterface<T> si) {
        lista.stream().forEach((t) -> {
            si.test(t);
        });
    }
    
    public static void metoda(String s){
        if(!s.isEmpty())
            System.out.println(s);
    }
    
    public static class SimpleOne implements SimpleInterface{
        @Override
        public void test(Object t) {
            System.out.println(t);
        }    
    }

}
