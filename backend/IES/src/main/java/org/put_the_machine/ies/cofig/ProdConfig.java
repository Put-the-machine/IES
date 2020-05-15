package org.put_the_machine.ies.cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("prod")
@Configuration
@PropertySource("classpath:application-prod.yaml")
public class ProdConfig {
}
