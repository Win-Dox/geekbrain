package sample.writer;

public class WriteToConsole implements Writer {
    @Override
    public void write(Object str1, Object str2) {
        System.out.println(str1);
        System.out.println(str2);
    }

    @Override
    public void write(String format, Object str1, Object str2) {
        System.out.println(String.format(format, str1, str2));
    }
}
