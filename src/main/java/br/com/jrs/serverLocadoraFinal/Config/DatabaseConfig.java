package br.com.jrs.serverLocadoraFinal.Config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://grudgingly-enlivened-albacore.data-1.use1.tembo.io:5432/jrs_locadora");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("WiGOd14WQgNMMyaZ");

        return dataSourceBuilder.build();
    }
}
