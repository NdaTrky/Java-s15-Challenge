package entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User extends AbstractEntity {

    private String name;
    private Map<Book, LocalDate> borrowedBooks; // Kitap ve teslim tarihi
    /* Eğer bir kitabın teslim tarihini kontrol etmek istiyorsak,
    Set<Book> bu bilgiyi saklamaz. Ancak bir Map<Book, LocalDate> yapısıyla her kitabı teslim tarihiyle ilişkilendirebiliriz.
    Eğer Set<Book> kullanırsanız, yalnızca kitapların listesini tutabilirsiniz, ancak teslim tarihlerini takip edemezsiniz.
    Map<Book, LocalDate> bu bilgiyi tutmanıza olanak tanır. Bu sebeple Set ifadesini Map ile güncelledim. */
    private boolean isBanned; // Kullanıcı ceza aldı mı?
    private LocalDate banEndDate; // Ceza bitiş tarihi

    public User(int id, String name) {
        super(id);
        this.name = name;
        this.borrowedBooks = new HashMap<>();
        this.isBanned = false;
        this.banEndDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Book, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book, LocalDate dueDate) {
        if (isBanned) {
            throw new IllegalStateException("Kullanıcı cezalı, şu an kitap ödünç alamaz!");
        }
        if (borrowedBooks.size() >= 5) {
            throw new IllegalStateException("En fazla 5 kitap ödünç alabilirsiniz!");
        }
        borrowedBooks.put(book, dueDate);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public LocalDate getBanEndDate() {
        return banEndDate;
    }

    public void setBanEndDate(LocalDate banEndDate) {
        this.banEndDate = banEndDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", isBanned=" + isBanned +
                ", banEndDate=" + banEndDate +
                '}';
    }
}
