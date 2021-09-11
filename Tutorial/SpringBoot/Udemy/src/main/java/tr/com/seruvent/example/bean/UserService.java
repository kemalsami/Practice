package tr.com.seruvent.example.bean;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Component yazılmaması durumunda @Autowired annotation kullanılamamaktadır
 */
@Component
public class UserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"kemal", new Date()));
        users.add(new User(2,"celal", new Date()));
        users.add(new User(3,"miray", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public void save(User u){
        users.add(u);
    }

    public User findOne(int id){
        for(User u: users){
            if(u.getId() == id)
                return u;
        }
        return null;
    }

}
