package sample.reader;

import java.util.Scanner;

public class ReadFromConsole implements Reader {
    private String exitCommand = "exit";

    @Override
    public String read() {
        System.out.println((Object) "Enter expression (or exit to exit): ");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        if (inputString.equals(exitCommand)) return null;
        return inputString;
    }
}
