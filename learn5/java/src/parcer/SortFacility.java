package parcer;

import java.util.List;
import java.util.Stack;

public class SortFacility{

    public static String toRPN (char[] str){
        return processToken(str);
    }

    public static String processToken(char[] inputString){
        List<Character> operators = List.of('-', '+', '/', '*');
        List<Character> separatorNumber = List.of('.', ',');
        Character openBracket = '(';
        Character closeBracket = ')';
        Stack<Character> stack = new Stack<>();

        StringBuilder outString = new StringBuilder();

        for (Character token : inputString) {
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
                    prevHeadStack = stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            Character prevHeadStack;
            do {
                prevHeadStack = stack.pop();
                outString.append(" ");
                outString.append(prevHeadStack);
            } while (!stack.isEmpty());

        }

        return outString.toString().replace(',', '.');
    }

}
