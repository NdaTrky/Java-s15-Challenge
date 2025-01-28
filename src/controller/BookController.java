package controller;

import entity.Book;
import entity.Category;
import exceptions.BookNotFoundException;
import service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private BookService bookService;
    private Scanner scanner;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.println("Kitap adı girin:");
        String name = scanner.nextLine();
        System.out.println("Yazar adı girin:");
        String author = scanner.nextLine();
        System.out.println("Kategori girin (Geçerli kategoriler: " + Arrays.toString(Category.values()) + "):");
        String categoryInput = scanner.nextLine();

        try {
            Category category = Category.valueOf(categoryInput.toUpperCase());
            Book book = new Book(0, name, author, category);
            bookService.addBook(book);
        } catch (IllegalArgumentException e) {
            System.out.println("Geçersiz kategori! Lütfen geçerli bir kategori girin.");
        }
    }


    public void updateBook() {
        System.out.println("Güncellemek istediğiniz kitabın ID'sini girin:");
        int id = scanner.nextInt();
        scanner.nextLine();
        // nextInt() sonrası oluşan yeni satır temizlenir. Aksi halde sonraki scanner.nextLine() doğrudan boş bir değer okuyabilir.
        try { // kitap bulunamazsa:
            Book book = bookService.getBookById(id);
            System.out.println("Yeni kitap adı girin:");
            String name = scanner.nextLine();
            System.out.println("Yeni yazar adı girin:");
            String author = scanner.nextLine();
            System.out.println("Yeni kategori girin (Geçerli kategoriler: " + Arrays.toString(Category.values()) + "):");
            String categoryInput = scanner.nextLine();

            try { // category hatalı girilirse
                Category category = Category.valueOf(categoryInput.toUpperCase());
                book.setName(name);
                book.setAuthor(author);
                book.setCategory(category);
                bookService.updateBook(book);
            } catch (IllegalArgumentException e) {
                System.out.println("Geçersiz kategori! Lütfen geçerli bir kategori girin.");
            }
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
        }
    }


    public void deleteBook() {
            System.out.println("Silmek istediğiniz kitabın ID'sini giriniz: ");
            int id = scanner.nextInt();

            try { // Belirtilen ID'ye sahip kitabı servis katmanına ileterek silme işlemini gerçekleştirmektir.
                bookService.deleteBook(id);
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage()); //yakalanan BookNotFoundException hatasına ait bir mesajı simgeler. (exceptions)
            }
    }


    public void listBooks(){
        List<Book> books = bookService.getAllBooks(); // Servis katmanından tüm kitapları almayı sağlar.
        if(books.isEmpty()) {
            System.out.println("Hiç kitap bulunamamaktadır.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }


}
