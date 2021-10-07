package tr.com.seruvent.udemy.springclouddummyconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudDummyConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDummyConfigServerApplication.class, args);
    }

}
