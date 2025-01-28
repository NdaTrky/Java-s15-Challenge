package repository;

// Repository katmanını generic repository yapısında da tasarlayabilirdik. Bu kodun
// tekrar kullanabilirliğini arttıran bir yapı sunar.


import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();


    //Kitap eklemek istediğimiz zaman:

    public void addBook(Book book){
        books.add(book);
        System.out.println("Kitap başarıyla eklendi!" + book.getName());
    }

    // kitabın id'sine göre kitabı bulmak istediğimiz zaman:

    public Book getBookById(int id){
        for(Book book : books){
            if(book.getId() == (id)) {
                return book;
            }
        }
        return null; // Eğer kitap bulunamazsa null dönecek.
    }

    // bütün kitapları listelemek istediğimizde:

    public List<Book> getAllBooks(){
        return books;
    }

    // Kitap bilgilerini güncellemek istediğimizde:

    public void updateBook(Book updatedBook) {
        for(int i = 0;i < books.size(); i++) {
            if(books.get(i).getId() == updatedBook.getId()){
                books.set(i, updatedBook);
                System.out.println("Kitap başarıyla güncellendi! " + updatedBook.getName());
                return;
            }
        }
        System.out.println("Güncellenecek kitap bulunamadı! " + updatedBook.getId());
        System.out.println("Mevcut kitaplar : " + getAllBooks());
    }

    // Id ile kitabı silmek istersek:

    public void deleteBook(int id){
        books.removeIf(book -> book.getId() == id);
        System.out.println("Kitap başarıyla silindi! " + id);
    }

}
