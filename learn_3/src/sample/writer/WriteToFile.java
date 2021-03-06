package sample.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class WriteToFile implements Writer {

    private final String pathToFile;

    public WriteToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    private void createFile() throws IOException {
        File f = new File(pathToFile);
        f.createNewFile();
    }

    @Override
    public void write(Object str1, Object str2) throws Exception {
        try {
            createFile();

            FileWriter file = new FileWriter(pathToFile);
            file.write(str1.toString());
            file.write("\n");
            file.write(str2.toString());
            file.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void write(String format, Object str1, Object str2) throws Exception {
        try {
            createFile();

            FileWriter file = new FileWriter(pathToFile);
            file.write(String.format(format, str1, str2));
            file.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
