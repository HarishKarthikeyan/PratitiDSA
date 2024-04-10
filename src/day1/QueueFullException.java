package day1;

public class QueueFullException extends Throwable {
    public QueueFullException(String queueFull) {
        System.out.println(queueFull);
    }
}
