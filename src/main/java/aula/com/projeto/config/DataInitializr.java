package aula.com.projeto.config;

import aula.com.projeto.entity.User;
import aula.com.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {


        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            this.createUser("Nataniel Paiva", "nataniel.paiva@gmail.com", "12");
            this.createUser("Fulano Paiva", "fulano.paiva@gmail.com", "127");
            this.createUser("Paiva Ciclano", "ciclano.paiva@gmail.com", "122");
        }

    }

    public void createUser(String name, String email, String numberHome) {

        User user = new User(name, email, numberHome);
        userRepository.save(user);
    }

}


