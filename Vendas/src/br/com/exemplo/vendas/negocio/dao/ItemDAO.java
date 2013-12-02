package br.com.exemplo.vendas.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Item;

public class ItemDAO extends GenericDAO<Item> {
	public ItemDAO(EntityManager em) {
		super(em);
	}

	public ItemDAO() {
		super(Persistence.createEntityManagerFactory("Vendas")
				.createEntityManager());
	}

	public boolean inserir(Item item) {
		boolean result = false;
		Item existenteItem = null;

		try {
			Query q = em.createQuery("from Item where id = :id");
			q.setParameter("id", item.getId());

			try {
				existenteItem = (Item) q.getSingleResult();
			} catch (NoResultException e) {
				existenteItem = null;
			}

			if (existenteItem == null) {
				em.persist(item);
			} else {
				item.setId(existenteItem.getId());
			}
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Item item) {
		boolean result = false;
		Item existenteItem = null;

		try {
			existenteItem = em.find(Item.class, item.getId());
			if (existenteItem != null) {
				em.merge(item);
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
			result = false;
		}
		return result;
	}

	public boolean excluir(Item item) {
		Item obj = null;
		boolean result = false;

		try {
			Query q = em.createQuery("from Item where id = :id");
			q.setParameter("codigo", item.getId());
			obj = (Item) q.getSingleResult();
			em.remove(obj);
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Item localizarPorId(Item item) {
		Item obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Item where id = :id");
			q.setParameter("id", item.getId());
			obj = (Item) q.getSingleResult();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}