package a3.emsi.theislamway.web;


import a3.emsi.theislamway.dao.UserRepository;
import a3.emsi.theislamway.entities.Hizb;
import a3.emsi.theislamway.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class IslamRestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/lu/{id}")
    public void hizbLu(@PathVariable(name = "id") Long id){
        User user = userRepository.findById(id).get();
        Collection<Hizb> ahzab = user.getHizbs();
        for (Hizb hizb : ahzab) {
            hizb.setLu(true);
        }
        userRepository.save(user);
    }
}
