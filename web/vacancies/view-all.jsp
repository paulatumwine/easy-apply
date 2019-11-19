<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/19/19
  Time: 2:43 PM
  To change this template use File :: Settings :: File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Easy Apply :: WAP 2019</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<main>
    <h1>Current Openings</h1>
    <c:if test="${size == 0}">
        <p>Sadly, there no listed openings at the moment :-(</p>
    </c:if>
    <c:forEach var="vacancy" items="${vacancies}">
        <div class="card border-primary mb-3">
            <c:set var="company" value="${vacancy.company}"/>
            <div class="card-header">${company.name}</div>
            <div class="card-body text-secondary">
                <small class="text-muted">${company.location} :: ${company.industry} :: ${company.website} :: Posted on ${vacancy.datePosted}</small>
                <h3 class="card-title">${vacancy.title}</h3>
                <p class="card-text">${vacancy.description}</p>
                <a href="${baseUrl}/view-detail?id=${vacancy.vacancyId}" class="btn btn-light">See Details</a>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
