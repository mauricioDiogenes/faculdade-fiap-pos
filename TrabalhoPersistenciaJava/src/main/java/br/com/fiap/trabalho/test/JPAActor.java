package br.com.fiap.trabalho.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAActor {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence .createEntityManagerFactory ("persistenceUnit");
		factory.close ();
	}
}
