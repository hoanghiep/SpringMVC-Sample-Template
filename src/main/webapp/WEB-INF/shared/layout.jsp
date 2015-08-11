<%-- 
    Document   : layout
    Created on : Jan 6, 2015, 11:17:39 PM
    Author     : hieptran
--%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><decorator:title default="Trang chủ" /></title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>

        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico" />
        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/touch-icon-iphone.png">
        <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/touch-icon-ipad.png">
        <link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/touch-icon-iphone-retina.png">
        <link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/touch-icon-ipad-retina.png">

        <meta name="msapplication-TileColor" content="#FFFFFF">
        <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/favicon-144.png">
        
        <link href="<c:url value="/resources/pure/0.5.0/pure.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/tipsy/tipsy.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/nprogress/nprogress.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/glyphicon/css/glyphicon.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/base/css/components.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/base/css/layout.css" />" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="<c:url value="/resources/jquery/2.1.1/jquery-2.1.1.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/underscore/1.7.0/underscore.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/react/0.12.0/react-with-addons.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/tipsy/jquery.tipsy.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/nprogress/nprogress.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/base/js/constants.js?v=1.0.0.1"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/base/js/jquery.setup.js?v=1.0.0.1"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/base/js/jquery.ajax.js?v=1.0.0.1"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/base/js/layout.js?v=1.0.0.1"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/base/js/current.user.js?v=1.0.0.1"/>"></script>
        
        <script src="<c:url value="/resources/base/js/ajax/request-server.js"/>" type="text/javascript"></script>
        
        <!-- BEGIN react-widgets -->
        <link href="<c:url value="/resources/react-widget/css/core.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/react-widget/css/react-widgets.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/react-widget/css/variables.css" />" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="<c:url value="/resources/react-widget/globalize.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/react-widget/react-widgets.js" />"></script>
        <!-- END react-widgets -->
        
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <script type="text/javascript">
            window.viewState = '<sec:authentication property="principal.loginUserInfo"/>';
            window.logoutUrl = "${logoutUrl}";
            window.baseUrl = "${pageContext.request.contextPath}/";
        </script>      
        <decorator:head />
    </head>
    <body>        
        <sec:authorize access="isRememberMe()">
        </sec:authorize>
        <sec:authorize access="isFullyAuthenticated()">
        </sec:authorize>
        <div id="app-layout" class="pure-g">
            <div id="top"></div>
            <div id="horizon-menu"></div>
            <div id="container">
                 <decorator:body/>
            </div>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/mixin/form-event-mixin.react.js"/>" type="text/javascript"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/mixin/validator-mixin.react.js"/>" type="text/javascript"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/common-validator-output.react.js"/>" type="text/javascript"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/mixin/ui-mixin.react.js?v=1.0.0.1"/>"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/mixed.react.js?v=1.0.0.1"/>"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/alert.react.js?v=1.0.0.1"/>"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/confirm.react.js?v=1.0.0.1"/>"></script>        
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/popup.react.js?v=1.0.0.1"/>"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/components/toast-message.react.js?v=1.0.0.1"/>"></script>
            <script type="text/javascript" src="<c:url value="/resources/base/js/build/users/logged-in-user.react.js?v=1.0.0.1"/>"></script>
                                       
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
            });
        </script>
        <div id="mask-cover"></div>
    </body>
</html>
