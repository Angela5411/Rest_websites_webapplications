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
import java.util.ArrayList;
import java.util.List;
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
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String idQTemplate="idQ";
    public static final String questionTemplate="question";
    public static final String a1Template="a1";
    public static final String a2Template="a2";
    public static final String a3Template="a3";
    public static final String a4Template="a4";
    public static final String correctTemplate="correct";
    @Id
    private Integer idQ;
    private String question;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private int correct;
    
    public Question() {
    }

    public Question(Integer idQ) throws JSONException, IOException 
    {
        this.idQ = idQ;
       /* Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.question/"+idQ);
        JSONObject json=new JSONObject(target.request(MediaType.APPLICATION_JSON).get(String.class));
       */ 
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.question/"+idQ);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        
        if (json!=JSONObject.NULL) 
        {
            question=json.getString(questionTemplate);
            a1=json.getString(a1Template);
            a2=json.getString(a2Template);
            a3=json.getString(a3Template);
            a4=json.getString(a4Template);
            correct=json.getInt(correctTemplate);
        }
    }

    public Question(Integer idQ,String question, String a1, String a2, String a3, String a4, int correct) {
        this.idQ = idQ;
        this.question=question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correct = correct;
    }
    public Question(String question, String a1, String a2, String a3, String a4, int correct) {
        this.question=question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correct = correct;
    }

    public Question(JSONObject json) throws JSONException
    {
        if(json.has(idQTemplate))
            idQ=json.getInt(idQTemplate);
        question=json.getString(questionTemplate);
        a1=json.getString(a1Template);
        a2=json.getString(a2Template);
        a3=json.getString(a3Template);
        a4=json.getString(a4Template);
        correct=json.getInt(correctTemplate);
        
    }
    public Integer getIdQ() {
        return idQ;
    }

    public void setIdQ(Integer idQ) {
        this.idQ = idQ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQ != null ? idQ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        return !((this.idQ == null && other.idQ != null) || (this.idQ != null && !this.idQ.equals(other.idQ)));
    }

    
    static public List<Question> findAll() throws JSONException, IOException
    {
       /* Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.question");
        JSONArray arr = new JSONArray(target.request(MediaType.APPLICATION_JSON).get(String.class));*/
        
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.question");
        String request=GETrequest(url);
        JSONArray arr=new JSONArray(request);
        
        List<Question> questions=new ArrayList<Question>();
        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                //JSONArray arr2 = obj.getJSONArray("fileName");
                Question temp=new Question(obj);
                questions.add(temp);
            }       
        }
        else 
            return null;
        return questions;
    }
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idQTemplate,idQ);
        json.put(questionTemplate,question);
        json.put(a1Template,a1);
        json.put(a2Template,a2);
        json.put(a3Template,a3);
        json.put(a4Template,a4);
        json.put(correctTemplate,correct);
        return json;
    }
    
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idQTemplate,this.idQ);
        json.put(questionTemplate,this.question);
        json.put(a1Template,this.a1);
        json.put(a2Template,this.a2);
        json.put(a3Template,this.a3);
        json.put(a4Template,this.a4);
        json.put(correctTemplate,this.correct);
        return json.toString();
    }

    public String getVerbalCorrect() 
    {
        switch (correct)
        {
            case 1:
                return this.a1;
            case 2:
                return this.a2;
            case 3:
                return this.a3;
            case 4:
                return this.a4;
            default: 
                return "0";
        }
        
    }
    
    static private String GETrequest(URL url) throws IOException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(  new InputStreamReader(con.getInputStream()));
        String inputLine;StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
    
    
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.question");   
        POSTrequest(this.toJSONObject(),url);
        
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
    }
     
}
