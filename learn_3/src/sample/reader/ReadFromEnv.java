package sample.reader;

import java.io.IOException;

public class ReadFromEnv implements Reader {

    private final String envName;

    public ReadFromEnv (String envName) {
        this.envName = envName;
    }

    @Override
    public String read() throws IOException, Exception {
        return System.getenv(envName);
    }
}
