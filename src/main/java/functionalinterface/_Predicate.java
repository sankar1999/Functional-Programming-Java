package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        // Normal Approach
        System.out.println("Normal Method...");
        System.out.println(isPhoneNumberValid("98789"));
        System.out.println(isPhoneNumberValid("54325"));

        // Predicate Approach
        System.out.println("Predicate Approach...");
        System.out.println(isPhoneNumberValidPredicate.test("98453"));
        System.out.println(isPhoneNumberValidPredicate.test("54324"));

        //
        System.out.println("Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("98365"));

        System.out.println("Is phone number valid or contains number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("98165"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("98") && phoneNumber.length() == 5;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("98") && phoneNumber.length() == 5;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
