package sample.parceToPolishNotation;

import java.util.List;
import java.util.Stack;

public class SortFacility implements ParseToPolishNotation{
    @Override
    public String parse(String inputString) throws Exception {
        List<Character> operators = List.of('-', '+', '/', '*');
        List<Character> separatorNumber = List.of('.', ',');
        Character openBracket = '(';
        Character closeBracket = ')';
        Stack<Character> stack = new Stack<>();

        StringBuilder outString = new StringBuilder();

        for (Character token : inputString.toCharArray()) {
            if (token.equals(' ')) continue;

            if (token.equals(openBracket)) {
                stack.push(token);
                continue;
            }

            if (Character.isDigit(token) || separatorNumber.contains(token)) {
                outString.append(token);
                continue;
            }

            if (operators.contains(token)) {
                outString.append(" ");
                if (!stack.isEmpty() && operators.indexOf(stack.peek()) >= operators.indexOf(token)) {
                    outString.append(stack.pop());
                    outString.append(" ");
                }
                stack.push(token);
                continue;
            }

            if (token.equals(closeBracket)) {
                Character prevHeadStack;
                prevHeadStack = stack.pop();
                while (!prevHeadStack.equals(openBracket)){
                    outString.append(" ");
                    outString.append(prevHeadStack);
                    if (stack.isEmpty()) throw new Exception("Bad formula");
                    prevHeadStack = stack.pop();
                }
                continue;
            }

            throw new Exception("Unexpected characters in a formula");
        }

        if (!stack.isEmpty()) {
            Character prevHeadStack;
            do {
                prevHeadStack = stack.pop();
                if (prevHeadStack.equals(openBracket)) throw new Exception("Bad formula");
                outString.append(" ");
                outString.append(prevHeadStack);
            } while (!stack.isEmpty());

        }

        return outString.toString().replace(',', '.');
    }
}
