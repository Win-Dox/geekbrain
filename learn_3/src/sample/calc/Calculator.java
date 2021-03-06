package sample.calc;

import java.util.Stack;

public class Calculator implements Calc {

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Double calculate(String polishNotation) throws Exception {
        Stack<Double> stack = new Stack<>();

        if (polishNotation == null || polishNotation.equals("")) {
            throw new Exception("Input string is empty");
        }

        for (String token : polishNotation.split(" ")) {
            if (token.equals("")) continue;

            if (isDouble(token)) {
                stack.push(Double.parseDouble(token));
                continue;
            }
            Double right = stack.pop();

            if (stack.isEmpty()) {
                if (token.equals("+") || token.equals("-")) stack.push(token.equals("+") ? right + 1 : right - 1);
                else throw new Exception("Bad formula");
                continue;
            }

            Double left = stack.pop();

            switch (token) {
                case "+" -> stack.push(left + right);

                case "-" -> stack.push(left - right);

                case "*" -> stack.push(left * right);

                case "/" -> stack.push(left / right);

            }
        }

        return stack.pop();
    }
}
