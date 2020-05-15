package org.put_the_machine.ies.cofig;

import org.springframework.context.annotation.*;

@Profile("dev")
@Configuration
@PropertySource("classpath:application-dev.yaml")
public class DevConfig {
}
