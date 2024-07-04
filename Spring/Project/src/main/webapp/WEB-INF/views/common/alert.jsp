<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>	
	
<script>
	function alertFunction(icon, title, text) {
		Swal.fire({
			icon: icon,
			title: title,
			text: text
		});
	}
	
	if(`${text}` != ``) {
		$().ready(function() {
			alertFunction(`${icon}`, `${title}`, `${text}`);
		})
	}

</script>