package br.com.fiap.trabalho.dao;

import br.com.fiap.trabalho.entity.Category;

/***
 * Interface responsal por definir os metodos do {@link CategoryDAO}
 * @author carlosrgomes@gmail.com
 *
 */
public interface CategoryDAO {
	public Category createCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public Category selectCategoryByName(String categoryName);
}
