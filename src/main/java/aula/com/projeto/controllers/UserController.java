package aula.com.projeto.controllers;

import aula.com.projeto.repository.UserRepository;
import aula.com.projeto.entity.User;
import aula.com.projeto.search.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSearch userSearch;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void findById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<User> search(@RequestParam("text") String text){
        return userSearch.search(text);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return userRepository.save(user);
    }

}
