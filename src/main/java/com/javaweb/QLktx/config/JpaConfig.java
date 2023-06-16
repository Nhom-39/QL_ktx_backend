package com.javaweb.QLktx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.javaweb.QLktx.repository")
public class JpaConfig {

}
