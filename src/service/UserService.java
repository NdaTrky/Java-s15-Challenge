package service;

import entity.User;
import entity.Book;
import repository.UserRepository;
import exceptions.UserLimitExceededException;

import java.time.LocalDate;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser (User user) {
        userRepository.addUser (user);
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public void updateUser (User updatedUser ) {
        userRepository.updateUser (updatedUser );
    }

    public void deleteUser (int id) {
        userRepository.deleteUser (id);
    }

    public void borrowBook(User user, Book book) throws UserLimitExceededException {
        if (user.getBorrowedBooks().size() >= 5) {
            throw new UserLimitExceededException("Kullanıcı 5 kitap limitine ulaştı!");
        }
        LocalDate dueDate = LocalDate.now().plusDays(15); // Ödünç alma süresi
        user.borrowBook(book, dueDate);
    }

    public void returnBook(User user, Book book) {
        user.returnBook(book);
    }
}