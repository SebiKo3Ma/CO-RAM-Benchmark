package logging;

public interface ILog {
    void write(long n);

    void write(String s);

    void write(Object ... values);

    void close();
}
