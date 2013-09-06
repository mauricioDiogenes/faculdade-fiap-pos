package br.com.fiap.trabalho.dao.jpa;

import javax.persistence.TypedQuery;
import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.entity.Category;

public class JPACategoryDAO extends JPAConnection implements CategoryDAO {

	public Category createCategory(Category category) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(category);
		getEntityManager().getTransaction().commit();
		return category;
	}

	public void deleteCategory(Category category) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(category);
		getEntityManager().getTransaction().commit();
	}

	public Category selectCategoryByName(String categoryName) {
		TypedQuery<Category> query = getEntityManager().createQuery(
				"SELECT c FROM Category c WHERE name = :name", Category.class);
		query.setParameter("name", categoryName);
		Category c = null;
		if (!query.getResultList().isEmpty()) {
			c = query.getResultList().get(0);
		}
		return c;
	}

}
