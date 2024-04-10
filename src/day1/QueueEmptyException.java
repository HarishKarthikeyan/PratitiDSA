package day1;

public class QueueEmptyException extends Throwable {
    public QueueEmptyException(String queueEmpty) {
        System.out.println(queueEmpty);
    }
}
