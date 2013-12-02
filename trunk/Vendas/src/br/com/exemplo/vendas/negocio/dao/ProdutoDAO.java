package br.com.exemplo.vendas.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {
	public ProdutoDAO(EntityManager em) {
		super(em);
	}

	public ProdutoDAO() {
		super(Persistence.createEntityManagerFactory("Vendas")
				.createEntityManager());
	}

	public boolean inserir(Produto produto) {
		boolean result = false;
		Produto existenteProduto = null;

		try {
			Query q = em.createQuery("from Produto where codigo = :codigo");
			q.setParameter("codigo", produto.getCodigo());

			try {
				existenteProduto = (Produto) q.getSingleResult();
			} catch (NoResultException e) {
				existenteProduto = null;
			}

			if (existenteProduto == null) {
				em.persist(produto);
			} else {
				produto.setCodigo(existenteProduto.getCodigo());
			}
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Produto produto) {
		boolean result = false;
		Produto existenteProduto = null;

		try {
			existenteProduto = em.find(Produto.class, produto.getCodigo());
			if (existenteProduto != null) {
				em.merge(produto);
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

	public boolean excluir(Produto produto) {
		Produto obj = null;
		boolean result = false;

		try {
			Query q = em.createQuery("from Produto where codigo = :codigo");
			q.setParameter("codigo", produto.getCodigo());
			obj = (Produto) q.getSingleResult();
			em.remove(obj);
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Produto localizarPorCodigo(Produto produto) {
		Produto obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Produto where codigo = :codigo");
			q.setParameter("codigo", produto.getCodigo());
			obj = (Produto) q.getSingleResult();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}