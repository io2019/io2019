package net.io.kino;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import net.io.kino.model.EmailConfirmation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import javax.mail.*;

import java.io.IOException;


@SpringBootApplication
public class KinoApplication {

    public static void main(String[] args) throws IOException, MessagingException {
        EmailConfirmation.sendmail();
        SpringApplication.run(KinoApplication.class, args);

    }

    @Bean
    public Module hibernate5Module() {
        return new Hibernate5Module();
    }

}
