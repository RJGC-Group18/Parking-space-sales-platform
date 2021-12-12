<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <style type="text/css">			<%--内部css--%>
    *{
        margin: 0px;
        padding: 0px;
        font-family: "microsoft yahei";
    }
    html,body{
        background-image: url(static/img/login-bg.png);
        background-size: 100% 100%;
        height: 100%;
    }
    .login{
        position: absolute;
        background-color: rgba(255,255,255,1);
        top: 25%;
        left: 60%;
        right: 10%;
        bottom: 25%;
        border-radius: 5px;
    }
    .title,.u,.p,.l,.xl,.tips,.s{
        position: absolute;
        width: 100%;
    }
    input{
        height: 35px;
        border: 0px;
        border-radius: 5px;
        width: 80%;
        padding-left: 18px;
        box-sizing: border-box;
    }
    .uname{
        background: url(static/img/login_user.png) no-repeat left;
        background-color: #F2F2FA;
    }
    .pwd{
        background: url(static/img/login_pwd.png) no-repeat left;
        background-color: #F2F2FA;
    }
    button{
        background-color: #467FE6;
        height: 35px;
        width: 80%;
        border: 0px;
        border-radius: 5px;
        color: #FFF;
        font-size: 16px;
    }
    select{
        width: 80%;
        height: 35px;
        border-radius: 4px;
        border:1px solid #e1e1e1;
    }
    .title{
        top: 0%;
        bottom: 80%;
        text-align: center;
        font-size: 25px;
        font-weight: bold;
        padding-top: 10px;
        box-sizing: border-box;
    }
    .u{
        top: 20%;
        bottom: 60%;
        left: 10%;
    }
    .p{
        top: 40%;
        bottom: 40%;
        left: 10%;
    }
    .s{
        top: 57%;
        bottom: 13%;
        left: 10%;
    }
    .l{
        top: 75%;
        bottom: 15%;
        left: 10%;
    }
     .xl{
        top: 85%;
        bottom: 15%;
        left: 10%;
    }
    .tips{
        top: 90%;
        font-size: 13px;
        color: red;
        text-align: center;
    }
    </style>
</head>
<body>
<s:div cssClass="login">
    <s:div cssClass="title">
        车位销售系统
    </s:div>
    <s:form action="userLogin" method="post">
        <s:div cssClass="u">
            <s:textfield theme="simple" cssClass="uname" name="user.username" value="账号名"/>
        </s:div>
        <s:div cssClass="p">
            <s:password theme="simple" cssClass="pwd" name="user.password" value="密码"/>
        </s:div>

        <s:div cssClass="l">
            <s:submit theme="simple" value="登录"/>
        </s:div>
         <s:div cssClass="xl">
             <s:a href="UserRegister.jsp"><input type="button" value="注册"/></s:a>
       </s:div> 
    </s:form>
    <s:div cssClass="tips">
        ${error}
    </s:div>
</s:div>
</body>
</html>
