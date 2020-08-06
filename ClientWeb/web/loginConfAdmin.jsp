<%-- 
    Document   : loginConfAdmin
    Created on : 25 Σεπ 2018, 12:23:11 μμ
    Author     : User
--%>

<%@page import="data.Exam"%>
<%@page import="data.ECenter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Administrator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Menu</title>
        <style>
            .back {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 10px;
            }
            .white{
            border: 20px solid white;
            }
            input[type=submit] {
            width: 100%;
            background-color: darkslategray;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        </style>
    </head>
    <body>
        <%
        Boolean found;
        String a_user=request.getParameter("username");      
        String a_pass=request.getParameter("password");
        Administrator temp=new Administrator(null,a_user,a_pass);
        temp.existsUsername();
        if(temp.getIdP()==null)
        {
            out.write("not found");
            %> <a href="loginAdmin.jsp">Sign in</a> <%
        }
        else
        {
            session = request.getSession(true);
            session.setAttribute("user", temp);

            List <ECenter> centers=new ArrayList<ECenter>();
            centers=ECenter.findAll();
            List<Exam> exams=new ArrayList<Exam>();
            exams=Exam.findAll();
        %> 
        <div class="back"><div class="row">
                <div class="col-sm-1"></div><div class="col-sm-4"><br><br>
                    <div class="white">
                    <form name="r1" action="Results1.jsp" >        
                        <h4>Αποτελέσματα εξεταζόμενων με βάση τον κωδικό εξέτασης</h4>
                        <h5> Κωδικός εξέτασης: </h5>
                        <input type="text" name="id"  />
                        <input  type = "submit" value = "Search" name = "r1" />
                    </form>
                    </div><br><br><br>
        
                    <div class="white">
                    <form name="r2" action="Results2.jsp">
                        <h4>Αποτελέσματα εξεταζόμενων για συγκεκριμένο εξεταστικό κέντρο</h4>
                        <h5> Εξεταστικό κέντρο: </h5>
                        <select name="center" >
                            <% for (ECenter center:centers ) {%>
                            <option value="<%=center.getECenterId()%>"><% out.write(center.getECenterName()); %></option><%}%>
                        </select><br/>
                        <input type="submit" value="Search" name="r2" />  
                    </form>
                    </div><br><br><br>
            
                    </div><div class="col-sm-2"></div><div class="col-sm-4"><br><br>
        
                    <div class="white" >           
                    <form name="r3" action="Results3.jsp">
                        <h4>Αποτελέσματα εξεταζόμενων για συγκεκριμένο εξεταστικό κέντρο και ημερομηνία</h4>
                        <h5> Εξεταστικό κέντρο και Ημερομηνία εξέτασης:</h5> 
                        <select name="examId" >
                            <% for (Exam exam:exams) if(exam.getExamDate()!=null) {%>
                            <option value="<%=exam.getExamId() %>"><% out.write(exam.getECenterId().getECenterName()+" "+exam.getExamDate().getDayOfWeek()+" "+exam.getExamDate().toLocalDate()+" "+exam.getExamDate().toLocalTime()); %></option><%}%>
                        </select> 
                        <br><input type="submit" value="Search" name="r3" /> 
                    </form>
                    </div><br><br><br>
            
                    <div class="white" class="block-inner">
                    <form name="r4" action="Results4.jsp">
                        <h4>Αποτελέσματα εξεταζόμενου</h4>
                        <h5> Κωδικός Εξεταζόμενου: </h5>
                        <input type="text" name="id"  />
                        <input type="submit" value="Search" name="r4" />
                    </form>
                    </div><br><br><br>
                    
                    </div><div class="col-sm-1"></div></div>
        <%}%>
        
        <div class="row"><div class="col-sm-5"></div><div class="col-sm-2">
        <form name="return" method="post" action="./index.xhtml">
            <input type="submit" value="return">
        </form></div><div class="col-sm-5"></div></div>
        
        </div> 
    </body>
</html>
