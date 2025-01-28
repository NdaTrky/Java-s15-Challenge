package entity;

import java.util.UUID;

public class AbstractEntity {

    private int id;

    public AbstractEntity(int id){
        this.id= id;
        // UUID sınıfı benzersiz tanımlayıcılar oluşturmak için kullanılır. Bu kısımda UUID sınıfını elemek zorunda kaldım.
        // Çünkü: AbstractEntity sınıfındaki yapıcı (constructor) metodunda, this.id = UUID.randomUUID().hashCode(); ifadesini kullanımı:
        //  id'yi her seferinde rastgele bir UUID değerinin hash kodu olarak ayarlıyor.
        //Ancak, bu durumda, Book sınıfında super(id) şeklinde bir çağrı yapılıyor.
        // super(id)'in amacı, üst sınıftaki id'yi, Book sınıfına geçerken doğru bir şekilde ayarlamaktır.
        // Ancak burada UUID.randomUUID().hashCode() kullanıldığı için, super(id) çağrısındaki id değeri gerçekten bir UUID hash kodu olmuyor, yalnızca rastgele bir
        // değere atanmış oluyor.

        /*
        Yani özetle biz id dediğimiz zaman bu sıralı oluyor örneğin 1-2-3-4-5-6 gibi.
         Ancak UUID sınıfnı kullandığımız zaman bu değerler daha dağınık olabilir örneğin 3-8-40-5-7 gibi.
         Bu şekilde sırasız olması da karmaşık bir yapı oluşturuyor. (Eğer hashCode olarak değil de String olarak kullansaydık böyle bir problemi engelleyerek UUID sınıfını kullanabilirdik.)
        */
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}

/*
AbstractEntity sınıfı, diğer entity sınıflarının ortak özelliklerini (örneğin, id) tutmak için kullanılır.
 Bu tasarım, kod tekrarını önler ve tüm entity sınıflarının belirli bir yapıya sahip olmasını sağlar.
 Bu nedenle, Book, Invoice ve User  gibi sınıflar, AbstractEntity sınıfından türetilir
  ve bu sayede id alanını miras alırlar.
*/