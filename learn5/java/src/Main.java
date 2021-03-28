import calc.Calculator;
import java.util.Scanner;
import monads.IO;
import parcer.SortFacility;

public class Main {

    private static char[] parseToList(String inString) {
        return inString.toCharArray();
    }

    public static void main(String[] args) {
        IO.apply(() -> "Введите выражение:")
                .mapToVoid(System.out::println)
                .map(v -> new Scanner(System.in).nextLine())
                .map(Main::parseToList)
                .map(SortFacility::toRPN)
                .map((v) -> {
                    System.out.println(v);
                    return v;
                })
                .map(Calculator::Run)
                .mapToVoid(System.out::println)
                .run();
    }
}

