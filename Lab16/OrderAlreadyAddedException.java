package Lab16;

public class OrderAlreadyAddedException extends Throwable {
    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}
