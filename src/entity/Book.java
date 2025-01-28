package entity;

import java.util.Objects;

public class Book extends AbstractEntity{
    private String name;
    private String author;
    private Category category;
    private boolean isAvailable; // Kitap ödünç alındı mı?


    public Book(int id, String name, String author, Category category){
        super(id);
        this.name = name;
        this.author = author;
        this.category = category;
        this.isAvailable = true; // varsayılan olarak kitap mevcut. Eğer alan olursa false olacak.

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}