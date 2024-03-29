package com.erc.his.config;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.type.LongType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

	private Session session;

	public HibernateConfig() {
		// Create type safe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		this.session = factory.openSession(); // TODO Auto-generated constructor stub

	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public Long generateID() {
		SQLQuery sqlQuery = getSession().createSQLQuery("select AA_PATIENT_SEQ.nextval value from dual");
		sqlQuery.addScalar("value", new LongType());
		return (Long) sqlQuery.uniqueResult();
	}

	public <T> void save(T object) {
		Session session = getSession();
		session.clear();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}

	public <T> void update(T object) {
		Session session = getSession();
		session.clear();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
	}

	public <T> T getData(Class<T> clazz, Long key) {
		return clazz.cast(getSession().load(clazz, key));
	}

}
