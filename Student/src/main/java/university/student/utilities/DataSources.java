package university.student.utilities;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSources {

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/client");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("osho");

		return dataSourceBuilder.build();

//		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//
//		spring.datasource.url=jdbc:mysql://localhost:3306/client
//		spring.datasource.username=root
//		spring.datasource.password=osho

	}
}
