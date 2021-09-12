package tr.com.seruvent.udemy.springbootexceptions.service;

import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.springbootexceptions.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(1, "kskaraca@gmail.com" , "Kemal" , "KARACA"));
        userList.add(new User(2, "cskaraca@gmail.com" , "Selçuk" , "KARACA"));
        userList.add(new User(3, "zmkaraca@gmail.com" , "Miray" , "KARACA"));
        userList.add(new User(4, "karaca001@gmail.com" , "Sami" , "KARACA"));
    }

    public List<User> findAll(){
        return userList;
    }

    public User findUser(int id){
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getId()==id)
                return userList.get(i);
        }

        return null;
    }

    public void saveUser(User user){
        userList.add(user);
    }

}
