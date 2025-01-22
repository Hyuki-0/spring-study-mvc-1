<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hyuki.springstudymvc1.domain.MemberRepository" %>
<%@ page import="com.hyuki.springstudymvc1.domain.Member" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("save-result.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
  성공
  <ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
  </ul>
  <a href="/index.html">메인</a>
</body>
</html>
