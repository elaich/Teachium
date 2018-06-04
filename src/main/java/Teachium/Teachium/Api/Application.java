package Teachium.Teachium.Api;

import Teachium.Teachium.database.TeachiumDatabase;
import Teachium.Teachium.database.TeachiumDatabaseImpl;
import Teachium.Teachium.domain.AdminService;
import Teachium.Teachium.domain.AdminServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public AdminService adminService() {
    return new AdminServiceImpl(teachiumDatabase());
  }

  @Bean
  public TeachiumDatabase teachiumDatabase() {
    return new TeachiumDatabaseImpl();
  }

}

