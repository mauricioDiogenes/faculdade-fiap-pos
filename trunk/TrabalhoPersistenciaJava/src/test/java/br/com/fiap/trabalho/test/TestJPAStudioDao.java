package br.com.fiap.trabalho.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Studio;

public class TestJPAStudioDao {
	private static StudioDAO studioDAO;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		studioDAO = abstractDAOFactory.createStudioDAO();
		Studio studio1 = new Studio();
		studio1.setName("Studio 1");
		studioDAO.createStudio(studio1);
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.studioDAO);
	}
	
	@Test
	public void insertStudio(){
		Studio studio = new Studio();
		studio.setName("Studio Insert");
		Studio c = studioDAO.createStudio(studio);
		assertNotNull(c);
	}
	
	@Test
	public void selectStudioByName(){
		List<Studio> studios = studioDAO.selectStudioByName("Studio 1");
		assertNotNull(studios);
	}
	
}
