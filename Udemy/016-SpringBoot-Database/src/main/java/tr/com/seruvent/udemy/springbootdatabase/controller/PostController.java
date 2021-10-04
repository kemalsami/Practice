package tr.com.seruvent.udemy.springbootdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootdatabase.model.Post;
import tr.com.seruvent.udemy.springbootdatabase.repository.PostRepository;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "posts")
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @GetMapping(path = "posts/{id}")
    public void getPost(@PathVariable int id){

    }

}
