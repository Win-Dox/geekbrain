package sample.reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFile implements Reader {

    private final String pathToFile;

    public ReadFromFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public String read() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString()
                    .replace("\n", "")
                    .replace("\r", "")
                    .replace("\t", "");
        }
    }
}
