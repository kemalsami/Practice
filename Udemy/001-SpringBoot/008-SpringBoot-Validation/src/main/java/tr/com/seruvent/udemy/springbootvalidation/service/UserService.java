package tr.com.seruvent.udemy.springbootvalidation.service;

import org.springframework.stereotype.Component;
import tr.com.seruvent.udemy.springbootvalidation.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(1,"Kemal" , "Karaca" , "kemalkaraca@gmail.com" , new Date()));
        userList.add(new User(2,"Sami" , "Karaca" , "samikaraca@gmail.com" , new Date()));
    }

    public List<User> findAll(){
        return userList;
    }


    public User findById(int id){
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getId()==id)
                return userList.get(i);
        }
        return null;
    }


    public void saveUser(User user){
        userList.add(user);
    }


    public void deleteUser(int id){
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getId()==id){
                userList.remove(i);
            }
        }

    }

}
