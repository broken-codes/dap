package org.brokencodes.learning.dap.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EntityScan(basePackages = {"org.brokencodes.learning.dap.beans"})
@EnableJpaRepositories(basePackages = {"org.brokencodes.learning.dap.repositories"})
public class ApplicationConfiguration {

    @Bean
    public StopWatch stopWatch() {
        return new StopWatch();
    }

}
