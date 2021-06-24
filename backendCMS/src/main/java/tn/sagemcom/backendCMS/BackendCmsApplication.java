package tn.sagemcom.backendCMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories("tn.sagemcom.Repositories")
@ComponentScan("tn.sagemcom")
@EntityScan("tn.sagemcom.Entities")
@SpringBootApplication
public class BackendCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCmsApplication.class, args);
	}

}
