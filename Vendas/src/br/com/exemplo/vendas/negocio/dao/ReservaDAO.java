package br.com.exemplo.vendas.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Reserva;

public class ReservaDAO extends GenericDAO<Reserva> {
	public ReservaDAO(EntityManager em) {
		super(em);
	}

	public ReservaDAO() {
		super(Persistence.createEntityManagerFactory("Vendas")
				.createEntityManager());
	}

	public boolean inserir(Reserva reserva) {
		boolean result = false;
		Reserva existenteReserva = null;

		try {
			Query q = em.createQuery("from Reserva where codigo = :codigo");
			q.setParameter("codigo", reserva.getCodigo());

			try {
				existenteReserva = (Reserva) q.getSingleResult();
			} catch (NoResultException e) {
				existenteReserva = null;
			}

			if (existenteReserva == null) {
				em.persist(reserva);
			} else {
				reserva.setCodigo(existenteReserva.getCodigo());
			}
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Reserva reserva) {
		boolean result = false;
		Reserva existenteReserva = null;

		try {
			existenteReserva = em.find(Reserva.class, reserva.getCodigo());
			if (existenteReserva != null) {
				em.merge(reserva);
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

	public boolean excluir(Reserva reserva) {
		Reserva obj = null;
		boolean result = false;

		try {
			Query q = em.createQuery("from Reserva where codigo = :codigo");
			q.setParameter("codigo", reserva.getCodigo());
			obj = (Reserva) q.getSingleResult();
			em.remove(obj);
			result = true;
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Reserva localizarPorId(Reserva reserva) {
		Reserva obj = null;
		boolean result = false;
		try {
			Query q = em.createQuery("from Reserva where codigo = :codigo");
			q.setParameter("codigo", reserva.getCodigo());
			obj = (Reserva) q.getSingleResult();
		} catch (Exception e) {
			if (debugInfo) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}