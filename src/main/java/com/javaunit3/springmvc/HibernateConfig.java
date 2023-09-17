package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory getFactory() {
        SessionFactory factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MovieEntity.class)
                .addAnnotatedClass(VoteEntity.class)
                .buildSessionFactory();

        return factory;
    }

    @Component
    public static class TitanicMovie implements Movie {

        @Override
        public String getTitle() {
            return "Titanic";
        }

        @Override
        public String getMaturityRating() {
            return "PG-13";
        }

        @Override
        public String getGenre() {
            return "Romance";
        }
    }
}


