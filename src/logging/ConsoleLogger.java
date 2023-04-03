package logging;

public class ConsoleLogger implements ILog{
    public void write(long n){
        System.out.println(n);
    }

    public void write(String s) {
        System.out.println(s);
    }

    public void write(Object ...values) {
        for (Object o : values)
            System.out.println(String.valueOf(o) + " ");
    }

    public void close() {

    }
}