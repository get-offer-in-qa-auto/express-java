package practice_8.library.exceptions;

// проверяемое -> Exception (наследников)
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
