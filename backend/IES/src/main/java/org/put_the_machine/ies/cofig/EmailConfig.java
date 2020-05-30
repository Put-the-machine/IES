package org.put_the_machine.ies.cofig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.mail.notification")
    public JavaMailSender notificationEmailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties props = mailSender.getJavaMailProperties();
        applyProperties(props);
        return mailSender;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.mail.user")
    public JavaMailSender userEmailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties props = mailSender.getJavaMailProperties();
        applyProperties(props);
        return mailSender;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.mail.properties")
    public Properties properties() {
        return new Properties();
    }

    private void applyProperties(Properties newProps) {
        Properties props = properties();
        for (String key : props.stringPropertyNames()) {
            newProps.put(key, props.getProperty(key));
        }
    }
}