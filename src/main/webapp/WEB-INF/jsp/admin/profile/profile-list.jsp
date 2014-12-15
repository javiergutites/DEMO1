<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<div class="title"><fmt:message key="admin.section.list"/></div>
	<table id="result-list-section">
		<thead>
			<tr>
				<th><fmt:message key="admin.profile.list.name"/> </th>
				<th><fmt:message key="admin.profile.list.description"/></th>
				<th><fmt:message key="admin.profile.list.roles"/></th>
				<th><fmt:message key="admin.profile.list.actions"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="profile" items="${profileList}">
				<tr>
					<td>${profile.name}</td>
					<td>${profile.description}</td>
					<td>
						<c:forEach var="role" items="${profile.roles}">
							${role.name}
						</c:forEach>
					</td>
					<td class="action">
						<a href="#" class="ui-icon ui-icon-pencil">&nbsp;</a>
						<a href="#" class="ui-icon ui-icon-closethick">&nbsp;</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#result-list-section').dataTable({
				"aoColumns": [
					{"sWidth": "6%", "bSortable": true},
				    {"sWidth": "25%", "bSortable": false},
				    {"sWidth": "10%", "bSortable": false},
				    {"sWidth": "4%", "bSortable": false},
				],
				"aaSorting": [[ 0, "asc" ]],
				"bJQueryUI": true,
				"sDom": 't<"F"lip>',
				"oLanguage": {
					"sLengthMenu": "Mostrando _MENU_ registros por página",
					"sZeroRecords": "No se ha encontrado información",
					"sInfo": "(del _START_ al _END_ de un total de _TOTAL_ registros)",
				},
			});
		});
	</script>