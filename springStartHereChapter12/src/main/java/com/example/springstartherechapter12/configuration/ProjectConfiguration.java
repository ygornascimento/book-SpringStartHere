package com.example.springstartherechapter12.configuration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfiguration {
    /* The connection details are configurable, so it's a good idea to continue defining them outside of the source code.
    In this example, we keep them in the application.properties file.
    */
    @Value("${custom.datasource.url}")
    private String datasourceUrl;
    @Value("${custom.datasource.username}")
    private String datasourceUsername;
    @Value("${custom.datasource.password}")
    private String datasourcePassword;

    @Bean // We annotate the method with @Bean to instruct Spring to add the returned value to its Context.
    public DataSource dataSource() { /* The method returns a DataSource object. If Spring Boot finds a DataSource already
    exits in the Spring context it doesn't configure one.*/

        /* We'll use HikariCP as the data source implementation for this example. However, when you define the bean yourself,
        you can choose other implementations if your project requires something else.*/
        HikariDataSource dataSource = new HikariDataSource();

        //We set the connection parameters on the data source.
        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);

        /* You can configure other properties as well (eventually in certain conditions). In this case, I use the connection
        timeout (how much time the data source waits for a connection before considering it can't get one) as an example.*/
        dataSource.setConnectionTimeout(1000);

        // We return the DataSource instance, and Spring adds it to its Context.
        return dataSource;
    }
}
