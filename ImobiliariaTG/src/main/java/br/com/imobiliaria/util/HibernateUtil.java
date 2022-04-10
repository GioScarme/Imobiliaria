package br.com.imobiliaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure();
			
			ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
			registry.applySettings(configuracao.getProperties());
			
			org.hibernate.service.ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
			
			SessionFactory sessionFactory = configuracao.buildSessionFactory(serviceRegistry);
			

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);

		}
	}
}
