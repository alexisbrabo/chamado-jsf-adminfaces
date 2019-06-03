package br.com.alexis.chamado.bancoDeDadosUtils;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ProdutorEntityManager {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ChamadoPU",
			setProperties());

	private EntityManager entityManager;

	protected void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}

	@Produces
	protected EntityManager createEntityManager() {
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	protected Properties setProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		properties.setProperty("hibernate.jdbc.batch_size", "20");
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:4306/chamado");
		properties.setProperty("hibernate.default_schema", "chamado");
		properties.setProperty("javax.persistence.jdbc.user", "root");
		properties.setProperty("javax.persistence.jdbc.password", "qwe123");
		properties.setProperty("org.hibernate.flushMode", "ALWAYS");
		return properties;
	}
}
