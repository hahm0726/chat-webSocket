<%--
  작성자: me
  마지막 변경일: 2021-12-01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>채팅 예제</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="input-group mb-3">
        <input id="msg" type="text" class="form-control">
        <div class="input-group-append">
            <button id="btn-send" class="btn btn-success">전송</button>
        </div>
    </div>
    <ul id="msg-area" class="list-group">
    </ul>
</div>
<script src="/js/chatting.js"></script>
</body>
</html>
