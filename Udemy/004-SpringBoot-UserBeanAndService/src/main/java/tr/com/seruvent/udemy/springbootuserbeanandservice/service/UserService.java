package tr.com.seruvent.udemy.springbootuserbeanandservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.springbootuserbeanandservice.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static ArrayList<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(1,"kskaraca@gmail.com"));
        userList.add(new User(2,"cskaraca@gmail.com"));
        userList.add(new User(3,"zmkaraca@gmail.com"));
    }

    public User getUserById(int id){
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getId() == id)
                return userList.get(i);
        }
        return null;
    }

    public User postUser(User user){
        userList.add(user);
        return user;
    }

    public List<User> getUserList(){
        return userList;
    };

}
