<%-- 
    Document   : Results3
    Created on : 25 Σεπ 2018, 12:38:47 μμ
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="data.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="data.Exam"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css">
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="https://account.genndi.com/assets/css/base.css">
        <title>Αποτελέσματα εξεταζόμενων για συγκεκριμένο εξεταστικό κέντρο και ημερομηνία</title>
    </head>
    <body>
        <%
        String id=request.getParameter("examId"); 
        try{
            Integer.parseInt(id);
        }catch(Exception e)
        {
            out.write("not found");
            %> <a href="loginAdmin.jsp">Wrong input</a> <%
        }
            
        Exam exam=new Exam().findbyId(Integer.parseInt(id));
        List<Answer> answers=new ArrayList<Answer>();
        answers=exam.findAnswersbyExam();
/*
        Collections.sort(answers, new Comparator<Answer>() {
        @Override
        public int compare(Answer lhs, Answer rhs) {
                return lhs.getIdA()-rhs.getIdA();
            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
           //return lhs.getIdP().getIdP() > rhs.getIdP().getIdP()? -1 : (lhs.customInt < rhs.customInt) ? 1 : 0;
        }
});*/
    %>
    <div class="row"><div class="col-sm-2">Κωδικός Απάντησης</div><div class="col-sm-4">Ερώτηση:</div><div class="col-sm-2">Σωστή Απάντηση:</div><div class="col-sm-2">Δοθείσα απάντηση:</div><div class="col-sm-2">Χρόνος απάντησης: </div></div><br>
        <ul type="square" >
        <% for (Answer answer:answers){%>
        <div class="row"><li>
                <div class="col-sm-1"><%out.write(answer.getIdA().toString());%></div>
                <div class="col-sm-5"><%out.write(answer.getIdQ().getQuestion());%></div>
                <div class="col-sm-2"><%out.write(answer.getCorrect());%></div>
                <div class="col-sm-2"><%out.write(answer.getAnswer());%></div>
                <div class="col-sm-2"><%out.write(answer.getTime().toString());%></div>
            
        </li></div><%}%>
        </ul>

    </body>
</html>
