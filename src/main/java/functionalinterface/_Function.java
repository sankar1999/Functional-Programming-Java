package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleBy10Funtion.apply(increment2);
        System.out.println(multiply);

        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;

    static Function<Integer, Integer> multipleBy10Funtion = number -> number * 10;

    static Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
            incrementByOneFunction.andThen(multipleBy10Funtion);

    static int increment(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
