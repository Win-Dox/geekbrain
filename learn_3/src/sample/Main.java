package sample;

import java.nio.file.Path;
import java.nio.file.Paths;
import sample.calc.Calc;
import sample.calc.Calculator;
import sample.parceToPolishNotation.ParseToPolishNotation;
import sample.parceToPolishNotation.SortFacility;
import sample.reader.ReadFromConsole;
import sample.reader.ReadFromFile;
import sample.reader.Reader;
import sample.writer.WriteToConsole;
import sample.writer.WriteToFile;
import sample.writer.Writer;

public class Main {
    public static void main(String[] args) throws Exception {
        new App().run();
    }
}

class App {

    private final ParseToPolishNotation parse = new SortFacility();
    private final Calc calc = new Calculator();

    private void calculate(Reader reader, Writer writer) throws Exception {
        String inputString = reader.read();
        String polishString = parse.parse(inputString);
        writer.write("%s\n%s", polishString, calc.calculate(polishString));
    }

    public void run() throws Exception {
//        calculate(new ReadFromConsole(), new WriteToConsole());

        Path input = Paths.get("test.txt");
        Path out = Paths.get("out.txt");

        calculate(new ReadFromFile(input.toString()), new WriteToFile(out.toString()));
    }
}