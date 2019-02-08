package ru.mpryanikov.advertisement.config;

@org.springframework.context.annotation.Configuration
public class AppConfig {


	@org.springframework.context.annotation.Bean(name="dataSource")
	public javax.sql.DataSource getDataSource(){
		//Создания источника данных
		org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		//Задание параметров подключения к базе данных
		dataSource.setUrl("jdbc:postgresql://localhost:5432/advertisement");
		dataSource.setUsername("postgres");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setPassword("postgres");
		return dataSource;
	}

	@org.springframework.context.annotation.Bean(name="entityManagerFactory")
	public org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean getEntityManager(){
	    //Создание класса фабрики реализующей интерфейс FactoryBean<EntityManagerFactory>
		org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean factory = new org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean();
		//Задание источника подключения
		factory.setDataSource(getDataSource());
		//Задание адаптера для конкретной реализации JPA,
		//указывает, какая именно библиотека будет использоваться в качестве постовщика постоянства
		factory.setJpaVendorAdapter(new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter());
	    //указание пакетов в котром будут находится классы-сущности
		factory.setPackagesToScan("ru.mpryanikov.advertisement.domain");

		//создание свойств для настройки Hibernate
		java.util.Properties jpaProperties = new java.util.Properties();
		//Указание диалекта конкретной базы данных,необходимо для генерации запросов Hibernate к БД
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		//Указание максимальной глубины связи(будет рассмотрено в след. уроке)
		jpaProperties.put("hibernate.max_fetch_depth", 3);
		//Определение максимального количества строк, возвращаемых за один запрос из БД
		jpaProperties.put("hibernate.jdbc.fetch_size", 50);
		//Определение максимального количества запросов при использовании пакетных операций
		jpaProperties.put("hibernate.jdbc.batch_size", 10);
		
		//Включает логгирование 
		jpaProperties.put("hibernate.show_sql", true);
		
		factory.setJpaProperties(jpaProperties);
		
		return factory;

	}
	

}
