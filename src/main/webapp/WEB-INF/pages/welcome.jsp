<%-- 
    Document   : home
    Created on : Nov 11, 2014, 12:08:20 AM
    Author     : hieptran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Workbench</title>
        <!--
                Used for including CSRF token in JSON requests
                Also see bottom of this file for adding CSRF token to JQuery AJAX requests
        -->
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    </head>
    <body>
        
    </body>
</html>

<%@ page session="false" %>
