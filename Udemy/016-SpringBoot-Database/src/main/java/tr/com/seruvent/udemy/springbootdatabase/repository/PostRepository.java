package tr.com.seruvent.udemy.springbootdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.seruvent.udemy.springbootdatabase.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post , Integer> {
}
