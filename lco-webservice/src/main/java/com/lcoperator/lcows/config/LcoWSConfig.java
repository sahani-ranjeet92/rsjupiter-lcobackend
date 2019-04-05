package com.lcoperator.lcows.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lcoperator.lcodb.config.LcoHibernateConfig;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@Import(LcoHibernateConfig.class)
public class LcoWSConfig {

}
