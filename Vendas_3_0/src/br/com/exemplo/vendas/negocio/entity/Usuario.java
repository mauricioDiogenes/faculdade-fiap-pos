package br.com.exemplo.vendas.negocio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {	
	
	@Id
	private String login ;
	
	@Column
	private String senha ;
	
	@Column
	private String grupo ;
	
	@Column
	private String perfil ;
	
	@Column
	private String bloqueado ;
	
	@Column
	private Date ultimoAcesso ;
	
	@Column
	private String nome ;
	
	public Usuario( )
	{
	}
	
	public Usuario( String login, String senha, String grupo, String perfil, String bloqueado, Date ultimoAcesso, String nome )
	{
		this.login 			= login ;
		this.senha 			= senha ;
		this.grupo 			= grupo ;
		this.perfil 		= perfil ;
		this.bloqueado 		= bloqueado ;
		this.ultimoAcesso 	= ultimoAcesso ;
		this.nome 			= nome;
	}
	
	public String getNome( )
    {
    	return nome;
    }

	public void setNome( String nome )
    {
    	this.nome = nome;
    }

	public String getLogin( )
    {
    	return login;
    }
	
	public void setLogin( String login )
    {
    	this.login = login;
    }
	
	public String getSenha( )
    {
    	return senha;
    }
	
	public void setSenha( String senha )
    {
    	this.senha = senha;
    }
	
	public String getGrupo( )
    {
    	return grupo;
    }
	
	public void setGrupo( String grupo )
    {
    	this.grupo = grupo;
    }
	
	public String getPerfil( )
    {
    	return perfil;
    }
	
	public void setPerfil( String perfil )
    {
    	this.perfil = perfil;
    }
	
	public String getBloqueado( )
    {
    	return bloqueado;
    }
	
	public void setBloqueado( String bloqueado )
    {
    	this.bloqueado = bloqueado;
    }
	
	public Date getUltimoAcesso( )
    {
    	return ultimoAcesso;
    }
	
	public void setUltimoAcesso( Date ultimoAcesso )
    {
    	this.ultimoAcesso = ultimoAcesso;
    }
	
	
}
