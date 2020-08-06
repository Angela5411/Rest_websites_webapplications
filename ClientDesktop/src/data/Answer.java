package data;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
/**
 *
 * @author User
 */
@Entity
@Produces("application/json")
@XmlRootElement
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String idATempate="idA";
    public static final String answerTemplate="answer";
    public static final String correctTemplate="correct";
    public static final String timeTemplate="time";    
    public static final String idPTemplate="idP";
    public static final String idQTemplate="idQ";

    

    
    @Id
    private Integer idA;
    private String answer;
    private String correct;
    private LocalDateTime time;
    private Examinee idP;
    private Question idQ;

    public Answer() {
    }

    public Answer(Integer idQ,Examinee idP) throws JSONException, IOException 
    {
        this.idQ=new Question(idQ);
        this.answer=null;
        this.correct=this.idQ.getVerbalCorrect();
        this.time=null;
        this.idP=idP;
        
    }

    public Answer(Answer another) {
        this.idQ = another.idQ; 
        this.answer=another.answer;
        this.correct=another.correct;
        this.time=another.time;
        this.idP=another.idP;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Examinee getIdP() {
        return idP;
    }

    public void setIdP(Examinee idP) {
        this.idP = idP;
    }

    public Question getIdQ() {
        return idQ;
    }

    public void setIdQ(Question idQ) {
        this.idQ = idQ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        return !((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA)));
    }

    
   
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        if(idA!=null)   json.put(idPTemplate,idA);
        json.put(answerTemplate,answer);
        json.put(correctTemplate,correct);        
        
        String date=this.time.toLocalDate()+" "+this.time.toLocalTime();
        json.put(timeTemplate,date);
        json.put(idPTemplate,idP.toJSONObject());
        json.put(idQTemplate,idQ.toJSONObject());
        
        return json;
        
    }
    
    
    
    
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idPTemplate,"");
        json.put(answerTemplate,this.answer);
        json.put(correctTemplate,this.correct);
        /*SimpleDateFormat format=new SimpleDateFormat(this.timeTemplate);
        String dateString=format.format(this.time);*/
        //json.put(timeTemplate,this.time.toString());    
        //json.put(timeTemplate,);
        json.put(idPTemplate,this.idP);
        json.put(idQTemplate,this.idQ);
        
        return json.toString();
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
      
    static  public List<Answer> prepareQuestions(int lim,Examinee examinee) throws JSONException, IOException
    {
        List <Question> questions=Question.findAll();
        List<Answer> answers=new ArrayList<Answer>(lim);
        Random rand = new Random();
        for (int i=0;i<lim;i++)
        {
            int  n = rand.nextInt(questions.size()) + 1;
            boolean flag=true;
            for(Answer a:answers)
                if(a.idQ.getIdQ()==n)
                {
                    flag=false;
                }
            if(flag)
            {
                Answer temp=new Answer(n,examinee);
                answers.add(temp);
            }
            else
                i--;
        }
        return answers;
    }
      
      public void submitAnswer(String res)
      {
        this.time=LocalDateTime.now();
        this.answer=res;
        
      }
      public void existsAnswer() throws JSONException, IOException
    {  
        
        /*Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.answer/max");
        JSONObject json=new JSONObject(target.request(MediaType.APPLICATION_JSON).get(String.class));
        */
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.answer/max");
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Integer max=json.getInt("");
        }
    }
      
    
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.answer");   
        POSTrequest(this.toJSONObject(),url);
        
    }
    
    
    private String GETrequest(URL url) throws IOException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        StringBuffer content;
        try (BufferedReader in = new BufferedReader(  new InputStreamReader(con.getInputStream()))) 
        {
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        }
        return content.toString();
    }
    
    private  void POSTrequest(JSONObject json,URL url) throws IOException, URISyntaxException, JSONException
    {
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setDoOutput (true); 
       connection.setRequestMethod("POST");        
       connection.setRequestProperty("Content-Type", "application/json;charset=utf-8;");        
       connection.connect();         
       DataOutputStream output = null;         
       
       JSONArray arr=new JSONArray();
       arr.put(json);
       System.out.println(arr.toString());
       output = new DataOutputStream(connection.getOutputStream());
       output.writeChars(arr.toString());
       output.flush();
            
      int status = connection.getResponseCode();
      System.out.print(status);

      /*   String charset = "UTF-8"; 
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");        
        connection.setDoOutput(true); // Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "text/html; charset="+charset);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);

        try (OutputStream output = connection.getOutputStream()) {
          output.write(json.toString().getBytes(charset));
        }
        
        
        
        int status = connection.getResponseCode();
        for (Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }
        String contentType = connection.getHeaderField("Content-Type");
        charset = null;

        

        if (charset != null) 
        {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset))) 
            {
                for (String line; (line = reader.readLine()) != null;) 
                {
                    System.out.println(line);
                }
            }
        } else {
             System.out.println("It's likely binary content, use InputStream/OutputStream");
        }
        
        
*/
        //return line.toString();
        
        /*HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8;");        
        connection.setDoInput (true); 
        connection.setDoOutput (true); 
        connection.setRequestMethod("POST");  
        
        OutputStream output = connection.getOutputStream();         
        output.write(json.toString().getBytes("utf-8"));
        
        InputStream input=new BufferedInputStream(connection.getInputStream());
        String result=IOUtils.toString(input,"utf-8");
        
        input.close();
        connection.disconnect();*/
        
        
    }
    

      public void nothing()
      {
          /*
           %><script type="text/javascript">
                    <!--
                    setTimeout('Redirect()',0);
                    function Redirect()
                    {location.href = 'login.xhtml';}
                    // --></script><%
          
          <!--    $('#question_form').submit(
            function () 
            {
            /*    document.getElementById("submit").preventDefault();
                var s=document.getElementById("submit").value;
                if(s.equals ("submit"))
                    submitAnswer();
                else if(s.equals("next"))
                    next();
                else
                    pass();
                return false;
            }) ;
          */
      }
}
