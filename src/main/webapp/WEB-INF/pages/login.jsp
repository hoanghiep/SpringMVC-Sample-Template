<%-- 
    Document   : login
    Created on : Nov 14, 2014, 8:53:57 PM
    Author     : hieptran
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/pure/0.5.0/pure.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/pure/0.5.0/grids-responsive.css"/>" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .login{
                width: 320px;
                box-sizing: border-box;
                margin: auto;
            }
            .login input[type="text"],input[type="password"]{
                width: 100%;
                margin-bottom: 10px;
            }
            .error{
                color: red;
            }
        </style>
    </head>
    <body onload='document.loginForm.username.focus();'>
            <div class="login">
                <h2>Đăng nhập hệ thống</h2>
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div>${msg}</div>
                </c:if>

                <form class="pure-form pure-form-stacked" name='loginForm' action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />" method='POST' autocomplete="off">
                    <div class="pure-g">
                        <div class="pure-u-1">
                            <label>Tài khoản</label>
                            <input type='text' name='username' placeholder="Tài khoản" value="" />
                        </div>    
                        <div class="pure-u-1">
                            <label>Mật khẩu</label>
                            <input class="jvFloat" type='password' name='password' placeholder="Mật khẩu" value="" />
                        </div>
                        <div class="pure-u-1">
                            <c:if test="${empty loginUpdate}">
                                <label for="remember-me"><input type="checkbox" name="remember-me" /> Nhớ tài khoản</label>
                                </c:if>
                        </div>
                        <button type="submit" class="pure-button pure-button-primary">Đăng nhập</button>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
