package repository;


import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();
/*ArrayList, dinamik bir dizi yapısıdır. Yani, başlangıçta belirli bir boyutla oluşturulmasına rağmen, eleman ekledikçe boyutunu otomatik olarak artırabilir.
Bu, kitap sayısının önceden bilinmediği durumlarda oldukça kullanışlıdır.*/


    // Kullanıcı eklemek istediğimizde:
    public void addUser(User user){
        users.add(user);
        System.out.println("Kullanıcı başarıyla eklendi!" + user.getName());
    }

    // ID ile kullanıcı listelemek istediğimizde:
    public User getUserById(int id) {
        for(User user : users ) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null; // eğer kullanıcı bulunamazsa null döner.
    }

    // Tüm kullanıcıları listelemek istersek
    public List<User> getAllUsers(){
        return users;
    }

    // Kullanıcı Bilgilerini güncellemek istediğimizde:
   public void updateUser(User updatedUser) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == updatedUser.getId()){
                users.set(i, updatedUser);
                System.out.println("Kullanıcı başarıyla güncellendi!" + updatedUser.getName());
                return;
            }
        }
        System.out.println("Güncellenecek kullanıcı bulunamadı! " + updatedUser.getId());
        System.out.println("Mevcut kullanıcılar : " + getAllUsers());
   }

   // Kullanıcı silmek istersek:
    public void deleteUser(int id){
        users.removeIf(user -> user.getId() == id);
        System.out.println("Kullanıcı başarıyla silindi" + id);
    }


    // Kullanıcı cezalı mı kontrol etmek:
    public void checkBanStatus(User user) {
        if(user.isBanned() && LocalDate.now().isAfter(user.getBanEndDate())) {
            user.setBanned(false);
            user.setBanEndDate(null);
        }
    }

    // Kullanıcıyı cezalandırmak
    public void imposeBan(User user, int banDays){
        user.setBanned(true);
        user.setBanEndDate(LocalDate.now().plusDays(banDays));
        System.out.println(user.getName() + "kullanıcısına, kitabı 15 gün içerisinde teslim etmediği için" + banDays + "günlük ceza verilmiştir.");
    }
}
