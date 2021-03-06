package sample.writer;

public interface Writer {
    void write(Object str1, Object str2) throws Exception;

    void write(String format, Object str1, Object str2) throws Exception;
}
