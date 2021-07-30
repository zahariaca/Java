package com.zahariaca.demohibernatewithdao;

import com.zahariaca.demohibernatewithdao.model.Cart;
import com.zahariaca.demohibernatewithdao.model.Items;
import com.zahariaca.demohibernatewithdao.repository.CartRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableTransactionManagement
public class DemoHibernateWithDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateWithDaoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CartRepository cartRepository) {

        Set<Items> items = new HashSet<>();
        items.add(new Items("One"));
        items.add(new Items("Two"));
        items.add(new Items("Three"));
        items.add(new Items("Four"));

        Cart cart1 = new Cart(items);



//        String[][] data = {
//                {"sea", "Andrew", "300.12", "NDK"},
//                {"creek", "Andrew", "100.75", "Piranha"},
//                {"loaner", "Andrew", "75", "Necky"}
//        };
//
//        return args -> {
//            Stream.of(data).forEach(array -> {
//                try {
//                    Kayak kayak = new Kayak(
//                            array[0],
//                            array[1],
//                            NumberFormat.getInstance().parse(array[2]),
//                            array[3]
//                    );
//                    System.out.println("Saving: " + kayak);
//                    kayakService.save(kayak);
//                }
//                catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            });
//            kayakService.findAll().forEach(System.out::println);
//    }

        ;
        return args -> {
            cartRepository.save(cart1);
        };
    }
}
