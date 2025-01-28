package service;

import entity.Book;
import exceptions.BookNotFoundException;
import repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public Book getBookById(int id) throws BookNotFoundException {
        Book book = bookRepository.getBookById(id);
        if(book == null) {
            throw new BookNotFoundException("Kitap bulunamadı");
        }
        return book;
    }

    public void updateBook(Book updatedBook) throws BookNotFoundException {
        if(bookRepository.getBookById(updatedBook.getId()) == null) {
            throw new BookNotFoundException("Güncellenecek kitap bulunamadı!");
        }
        bookRepository.updateBook(updatedBook);
    }

    public void deleteBook(int id) throws BookNotFoundException {
        if(bookRepository.getBookById(id) == null) {
            throw new BookNotFoundException("Silinecek kitap bulunamadı!");
        }
        bookRepository.deleteBook(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
