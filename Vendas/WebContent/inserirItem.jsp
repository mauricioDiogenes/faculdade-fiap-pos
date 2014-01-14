<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:if test="${ empty sessionScope.listarReserva }">
	<c:redirect url="vendas.do?action=ListarReserva&page=inserirItem.jsp" />
</c:if>

<c:if test="${ empty sessionScope.listarProdutos }">
	<c:redirect url="vendas.do?action=ListarProdutos&page=inserirItem.jsp" />
</c:if>

<html> 
	<head>
		<title>Cadastrar Item</title>
		<script type="text/javascript">
		<!--
			function setarFoco( campo ) {
				if( document.getElementById("uc54_dscSistemaCaixa").style.display != "none" ) {
					document.formulario.elements[campo].focus();
				}
			}
			
			function setStatus( texto ) {
				window.status=texto;
			}
		
			function validationForm() {
				var descricao 	  			= document.formulario.descricao.value;
				var preco 	  			= document.formulario.preco.value;
				var estoque 	  			= document.formulario.estoque.value;
				var msgError			= "Campo obrigat�rio n�o informado";
				
				if ( descricao == "" || descricao <= 0 ) 
				{
					window.alert( msgError );
					document.formulario.login.focus();
					return false;
				}
				if ( preco == "" || preco <= 0 ) 
				{
					window.alert( msgError );
					document.formulario.senha.focus();
					return false;
				}
				if ( estoque == "" || estoque <= 0 ) 
				{
					window.alert( msgError );
					document.formulario.grupo.focus();
					return false;
				}
			}

			function confirmation() {
				if ( validationForm() ) {
					var answer = confirm("Confirma a inser��o ?")
					if ( answer ) {
						document.formulario.submit();
					}
				}	
			}
		//-->
		</script>
	
	</head>
	

	
	
	
<body>
	<div id="sep_topodestaqueb"><img src="images/space.gif" width="1" height="1" /></div>
	<div id="conteudo-fb">
		<div id="margem">
			<div id="uc54_tela_principal_cadastrar_sistema">
				<span class="texto_corpo_pequeno">Cadastros  </span><span class="texto_titulos_pequeno">&raquo; Cadastrar Produto <br />  <br /></span>  <span class="texto_titulos_grande">&raquo; Cadastrar Usu�rio <br />  <br /></span><span class="texto_titulos_grande"> </span>
				
				<form id="formulario" name="formulario" action="vendas.do?action=InserirProduto" method="post">
	  				
	  				<table width="95%" border="0" cellspacing="3" cellpadding="0">
	    				<tr>
	      					<td height="20" colspan="2" bgcolor="#8993A7" class="texto_titulos_tabela">&nbsp;&nbsp;<strong>Dados Gerais </strong></td>
	    				</tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Quantidade&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="descricao" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
					    <tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Valor&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="preco" type="text" class="forms" size="8" maxlength="8" /></td>
					    </tr>
					    <tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Situacao&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="estoque" type="text" class="forms" size="20" maxlength="20" /></td>
					    </tr>
					    <tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Reserva&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="estoque" type="text" class="forms" size="20" maxlength="20" /></td>
					    </tr>
					    
					    
					    <tr>
						    <td width="200" height="20">&nbsp;</td>
						    <td>
						    	<c:if test="${ not empty sessionScope.reservaList }">
									<select name="reserva" id="reserva">
							      		<c:forEach var="reserva" items="${sessionScope.reservaList}">
							      			<option value="${reserva.codigo }">${reserva.codigo}</option>
								      	</c:forEach>
									</select>
						    	</c:if>
						    </td>
					    </tr>

					    <tr>
						    <td width="200" height="20">&nbsp;</td>
						    <td>
						    	<c:if test="${ not empty sessionScope.listarProdutos }">
									<select name="reserva" id="reserva">
							      		<c:forEach var="produto" items="${sessionScope.listarProdutos}">
							      			<option value="${produto.codigo }">${produto.codigo} ${produto.descricao}</option>
								      	</c:forEach>
									</select>
						    	</c:if>
						    </td>
					    </tr>

				 	</table>
					<table width="95%" border="0" cellpadding="0" cellspacing="3">				    
						<tr id="uc54_Cadastrar">
					    	<td width="200">&nbsp;</td>
					      	<td><input name="Button" type="button" class="texto_corpo" value="Cadastrar" onclick="confirmation()"/></td>
					    </tr>
					    <tr>
					      	<td width="200" height="20">&nbsp;</td>
					      	<td><span class="texto_corpo">(<span class="texto_vermelho">*</span>) Campos de preenchimento obrigat&oacute;rio. </span></td>
					    </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<div id="menue-fb">
		<div class="paddingwrap">
    		<ul>
      			<li id="mlink"><a href="#"><span>Ajuda</span></a></li>
      			<li id="mlink"><a href="javascript:history.go(-1)"><span>Voltar</span></a></li>
    		</ul>
		</div>
	</div>

</body>
</html>
