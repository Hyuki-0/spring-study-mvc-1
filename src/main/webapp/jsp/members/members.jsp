<%@ page import="java.util.List" %>
<%@ page import="com.hyuki.springstudymvc1.domain.Member" %>
<%@ page import="com.hyuki.springstudymvc1.domain.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> list = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : list) {
          out.write("       <tr>");
          out.write("           <td>" + member.getId() + "</td>");
          out.write("           <td>" + member.getUsername() + "</td>");
          out.write("           <td>" + member.getAge() + "</td>");
          out.write("       </tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
