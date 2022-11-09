package liga.medical.messageanalyzer.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.messageanalyzer", "liga.medical.commonmodule"})
@EnableJpaRepositories("liga.medical.commonmodule.service.repository")
@EntityScan("liga.medical.commonmodule.dto.entity")
public class MessageAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageAnalyzerApplication.class, args);
    }
}
