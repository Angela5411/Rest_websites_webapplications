<%-- 
    Document   : Results1
    Created on : 25 Σεπ 2018, 12:38:26 μμ
    Author     : User
--%>

<%@page import="data.Answer"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="data.Examinee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="data.Exam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css">
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/base.css">
        <title>Αποτελέσματα εξεταζόμενων με βάση τον κωδικό εξέτασης</title>
    </head>
    <body>
        <%
        String id=request.getParameter("id"); 
        try{
            Integer.parseInt(id);
        }catch(Exception e)
        {
            out.write("not found");
            %> <a href="loginAdmin.jsp">Wrong input</a> <%
        }
            
        Exam exam=new Exam().findbyId(Integer.parseInt(id));
        List<Examinee> examinees=new ArrayList<Examinee>();
        examinees=exam.findExamineessbyExam();
        Map<Integer, List<Answer>> map = new HashMap<Integer, List<Answer>>();
        for(Examinee examinee:examinees)
        {
            map.put(examinee.getIdP(), Answer.findbyExaminee(examinee.getIdP()));
        }
    %>
     <div class="row"><div class="col-sm-2">Κωδικός Απάντησης</div><div class="col-sm-4">Ερώτηση:</div><div class="col-sm-2">Σωστή Απάντηση:</div><div class="col-sm-2">Δοθείσα απάντηση:</div><div class="col-sm-2">Χρόνος απάντησης: </div></div><br>
        
    <ul type="circle">
        <% for(Examinee examinee:examinees) {%>
        <ul type="square" >
            <li><% out.write( "examineeid: "+examinee.getIdP()  ); %></li>
            <%for(Answer answer:map.get(examinee.getIdP())) {%>
            <div class="row"><li>
                    <div class="col-sm-1"><%out.write(answer.getIdA().toString());%></div>
                    <div class="col-sm-5"><%out.write(answer.getIdQ().getQuestion());%></div>
                    <div class="col-sm-2"><%out.write(answer.getCorrect());%></div>
                    <div class="col-sm-2"><%out.write(answer.getAnswer());%></div>
                    <div class="col-sm-2"><%out.write(answer.getTime().toString());%></div>

            </li></div><%}%>
        </ul><%}%>
    </ul>
    </body>
</html>
