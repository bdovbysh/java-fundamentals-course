package com.bobocode.fp;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

       intFunctionMap.addFunction("abs", integer -> Math.abs(integer));
       intFunctionMap.addFunction("sgn", integer -> Integer.signum(integer));
       intFunctionMap.addFunction("increment", a -> a + 1);
       intFunctionMap.addFunction("decrement", a -> a - 1);
       intFunctionMap.addFunction("square", a -> a * a );

        return intFunctionMap;
    }
}
