package tr.com.seruvent.udemy.springbootactuator.service;

import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.springbootactuator.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User("kskaraca@gmail.com" , "kemal", "karaca"));
        userList.add(new User("cskaraca@gmail.com" , "celal", "karaca"));
    }


    public List<User> findAll(){
        return userList;
    }

    public User findUserById(int id){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getId()==id)
                return userList.get(i);
        }
        return null;
    }

    public User saveUser(User user){
        userList.add(user);
        return user;
    }

    public void deleteUserById(int id){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getId()==id)
                userList.remove(i);
        }
    }

}
