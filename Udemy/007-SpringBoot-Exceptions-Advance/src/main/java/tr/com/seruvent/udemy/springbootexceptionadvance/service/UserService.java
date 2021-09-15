package tr.com.seruvent.udemy.springbootexceptionadvance.service;

import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.springbootexceptionadvance.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList;

    static{
        userList = new ArrayList<>();
        userList.add(new User(1,"kskaraca@gmail.com"));
        userList.add(new User(2,"cskaraca@gmail.com"));
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

}
