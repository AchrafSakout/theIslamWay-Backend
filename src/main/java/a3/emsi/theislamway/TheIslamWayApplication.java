package a3.emsi.theislamway;

import a3.emsi.theislamway.entities.Hizb;
import a3.emsi.theislamway.service.IslamwayInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TheIslamWayApplication implements CommandLineRunner {
    @Autowired
    private IslamwayInitService islamwayInitService;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(TheIslamWayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Hizb.class);
        islamwayInitService.initGroup();
        islamwayInitService.initUser();
        islamwayInitService.initHizb();
        System.out.println("Fin init");
    }
}
