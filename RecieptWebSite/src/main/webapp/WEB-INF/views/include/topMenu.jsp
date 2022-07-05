<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Main</title>
    <style>
      header {
        display: flex;
        padding: 0 10% 0 10%;
        margin: 0 auto;
      }
      .menu {
        float: right;
        margin: 0;
        padding: 0;
        border: 1px solid black;
        width: 100%;
      }
      .menu li {
        float: left;
        margin-left: 20px;
      }
      #logo {
        float: left;
        border: 1px solid black;
        width: 50%;
        font-weight: bold;
        font-size: 2rem;
      }
      ul,
      li {
        list-style-type: none;
      }
    </style>
  </head>
  <body>
    <header>
      <div id="logo">
        <a href="/main">To Buy Or Not To Buy</a>
      </div>
      <div class="menu">
        <ul>
          <li><a href="/main/vote/list/all">살까말까</a></li>
          <li><a href="">이 달의 영수증</a></li>
          <li><a href="">정보 게시판</a></li>
          <li id="login"><a href="">로그인</a></li>
          <li id="my"><a href="">회원가입</a></li>
        </ul>
      </div>
    </header>
  </body>
</html>
