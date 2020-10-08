package org.brokencodes.learning.dap.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"org.brokencodes.learning.dap.beans"})
@EnableJpaRepositories(basePackages = {"org.brokencodes.learning.dap.repositories"})
public class ApplicationDatabaseConfiguration {

}
