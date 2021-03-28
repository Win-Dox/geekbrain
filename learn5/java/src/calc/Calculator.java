package calc;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import monads.StackCalc;
import monads.State;

public class Calculator {

    public static String Run(String input) {
        return State.apply(StackCalc.apply(new Stack<Double>(), List.of(input.split("")).iterator()))
                .map(Calculator::calculate)
                .map(v -> v.get_1().peek())
                .toString();
    }


    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static StackCalc<Stack<Double>, Iterator<String>> calculate(StackCalc<Stack<Double>, Iterator<String>> state) {
        Iterator<String> it = state.get_2();
        if (!it.hasNext()) return state;

        String token = it.next();
        if (token.equals("") || token.equals(" ")) return calculate(state);

        if (isDouble(token)) {
            return calculate(state.modify(stack -> {
                stack.push(Double.parseDouble(token));
                return stack;
            }));
        }

        return state.modify(stack -> {
            Double right = stack.pop();
            Double left = stack.pop();

            switch (token) {
                case "+" -> stack.push(left + right);

                case "-" -> stack.push(left - right);

                case "*" -> stack.push(left * right);

                case "/" -> stack.push(left / right);

            }
            return stack;
        });
    }
}
