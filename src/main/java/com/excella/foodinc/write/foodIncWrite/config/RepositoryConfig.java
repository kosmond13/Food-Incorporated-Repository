package com.excella.foodinc.write.foodIncWrite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;

@Configuration
@EnableJdbcRepositories("com.excella.foodinc.repositories")
@EnableTransactionManagement
public class RepositoryConfig extends JdbcConfiguration{
}
