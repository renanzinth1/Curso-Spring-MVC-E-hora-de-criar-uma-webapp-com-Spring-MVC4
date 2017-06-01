<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Alterar Conta</h3>
		<form action="alteraConta" method="post">
	
			Descrição:<br/>
			<textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea>
			<br/>
	
			Valor:<br/>
			<input name="valor" type="text" value="${conta.valor}"><br/>
	
			Tipo:<br/>
			<select name="tipo">
				<option value="ENTRADA" ${conta.tipo == 'ENTRADA' ? 'selected' : ''}>Entrada</option>
				<option value="SAIDA" ${conta.tipo == 'SAIDA' ? 'selected' : ''}>Saida</option>
			</select>
			<br/>
	
			Pago? <input name="paga" type="checkbox" ${conta.paga ? 'checked' : ''} />
			<br/>
		
			Data de Pagamento: <input name="dataPagamento" type="text" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" />" />
			<br/>
	
			<input name="id" type="hidden" value="${conta.id}" />
			<input type="submit" value="Alterar">
		</form>
</body>
</html>