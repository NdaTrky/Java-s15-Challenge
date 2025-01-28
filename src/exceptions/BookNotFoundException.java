package exceptions;

// Kitap bulunamadığında oluşacak exception.

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (String message) {
        super(message);
    }
}
