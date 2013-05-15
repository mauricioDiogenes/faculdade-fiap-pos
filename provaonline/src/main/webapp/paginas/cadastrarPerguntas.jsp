<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="css/structure.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
<!-- JavaScript -->
	<script src="scripts/wufoo.js">
</script>
<script>
	$(document).ready(function() {
		$("#voltar").click(function() {
			parent.history.back();
			return false;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="container" class="ltr">

		<h1 id="logo">
			<a href="" title="Cadastrar Perguntas">Cadastrar Perguntas</a>
		</h1>

		<form id="form64" name="form64" class="wufoo topLabel page"
			autocomplete="off" method="post" novalidate action="CadastrarPerguntas">

			<header id="header" class="info">
			<h2>Cadastro de Perguntas</h2>
			</header>

			<ul>

				<li id="foli1" class="notranslate      "><label class="desc"
					id="title1" for="Field1"> Pergunta <span id="req_1" class="req">*</span>
				</label>
				
				<textarea rows="6" cols="70" name="questao">Digite sua pergunta....</textarea> 
						
			</li>
				<li class="buttons ">
					<div>

						<input id="saveForm" name="salvar" class="btTxt submit"
							type="submit" value="Submit" />

						<button id="voltar" type="button" class="btTxt submit">Voltar</button>
					</div>
				</li>

			</ul>
		</form>

	</div>
	<!--container-->



</body>
</html>