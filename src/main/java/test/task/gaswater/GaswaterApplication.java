package test.task.gaswater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GaswaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaswaterApplication.class, args);
    }

}
