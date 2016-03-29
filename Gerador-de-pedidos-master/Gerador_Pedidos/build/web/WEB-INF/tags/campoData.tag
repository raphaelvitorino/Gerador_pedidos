<%-- 
    Document   : campoData
    Created on : 28/03/2016, 19:26:56
    Author     : fabiano.eger
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>
<input id="${id}" name="${id}" value="${value}">
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>