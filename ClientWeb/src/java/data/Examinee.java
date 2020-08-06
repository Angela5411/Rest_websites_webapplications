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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement

public class Examinee implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String idPTemplate="idP";
    public static final String nameTemplate="name";
    public static final String usernameTemplate="username";
    public static final String passwordHashTemplate="passwordHash";
    public static final String examIdTemplate="examId";
    @Id
    private Integer idP;
    private String name;
    private String username;
    private String passwordHash;
    private Exam examId;

    public Examinee() {
    }

    public Examinee(Integer idP, String name, String username, String passwordHash, Exam examId) {
        this.idP = idP;
        this.name = name;
        this.username = username;
        this.passwordHash = passwordHash;
        this.examId = examId;
    }

    public Examinee(JSONObject json) throws JSONException 
    {
        if(json.has(idPTemplate))
            this.idP = json.getInt(idPTemplate);
        this.name = json.getString(nameTemplate);
        this.username = json.getString(usernameTemplate);
        this.passwordHash = json.getString(passwordHashTemplate);
        if(json.has(examIdTemplate))
            this.examId = new Exam(json.getJSONObject(examIdTemplate));
        
    }
       
       
    public Examinee(Integer idP) {
        this.idP = idP;
    }

    public Examinee(Integer idP, String name, String username) {
        this.idP = idP;
        this.name = name;
        this.username = username;
    }

    public Examinee(String name,String username,String password)
    {
        this.name=name;
        this.username=username;
        this.passwordHash=password;
    }
    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examinee)) {
            return false;
        }
        Examinee other = (Examinee) object;
        return !((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP)));
    }

    @Override
    public String toString() {
        return "Examinee: idP= " + idP + " name= "+name+" username= "+username;
    }
    
    public void existsUsername() throws JSONException, MalformedURLException, IOException
    {  
        /*
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.examinee/username/"+username);
        JSONObject json=new JSONObject(target.request(MediaType.APPLICATION_JSON).get(String.class));
        */
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee/username/"+username);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            if(name.equals(json.getString(nameTemplate)) && passwordHash.equals(json.getString(passwordHashTemplate)))
            {
                idP=json.getInt(idPTemplate);
                examId=new Exam(json.getJSONObject(examIdTemplate));
            }   
        }
    }
    
    public  Examinee findbyUsername(String username) throws JSONException, MalformedURLException, IOException
    {
            URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee/username/"+username);
            String request=GETrequest(url);
            JSONObject json=new JSONObject(request);
            if (json!=JSONObject.NULL) 
            {
                Examinee temp=new Examinee(json);        
                return temp;
            }
            return null;
    }
    
    public  Examinee findbyId(Integer id) throws JSONException, MalformedURLException, IOException
    {
            URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee/"+id);
            String request=GETrequest(url);
            JSONObject json=new JSONObject(request);
            if (json!=JSONObject.NULL) 
            {
                Examinee temp=new Examinee(json);        
                return temp;
            }
            return null;
    }
    
    public  void updateExam(Exam exam) throws Exception
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee/updateexam/"+this.idP+"/"+exam.getExamId());
        System.out.println(url);
        GETrequest(url); 
    }
    
    public void updateExaminee() throws Exception
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee/updateexaminee");
        JSONObject json=this.toJSONObject();
        POSTrequest(json,url);
    }
    
    public List<Answer> findbyExaminee() throws JSONException
    {
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.answer/findbyexaminee/"+this.getIdP());
        JSONArray arr=new JSONArray(target.request(MediaType.APPLICATION_JSON).get(String.class));
        List<Answer> questions=new ArrayList<Answer>();

        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                Answer temp=new Answer(obj);
                questions.add(temp);
            } 
            return questions;
        }
        return null;
    }
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        if(idP!=null)
            json.put(idPTemplate,idP);
        json.put(nameTemplate,name);
        json.put(usernameTemplate,username);   
        json.put(passwordHashTemplate,passwordHash);  
        if(examId!=null)
            json.put(examIdTemplate,examId.toJSONObject());
        return json;
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
    
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idPTemplate,this.idP);
        json.put(nameTemplate,this.name);
        json.put(usernameTemplate,this.passwordHash);    
        json.put(examIdTemplate,this.examId);
        return json.toString();
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
    
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.examinee");   
        POSTrequest(this.toJSONObject(),url);
        
    }
    
    private String GETrequest(URL url) throws IOException
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
    
    private  int POSTrequest(JSONObject json,URL url) throws IOException, URISyntaxException, JSONException
    {
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setDoOutput (true); 
       connection.setRequestMethod("POST");        
       connection.setRequestProperty("Content-Type", "application/json;charset=utf-8;");        
       connection.connect();         
       DataOutputStream output = null;         
       
       JSONArray arr=new JSONArray();
       arr.put(json);
       output = new DataOutputStream(connection.getOutputStream());
       output.writeChars(arr.toString());
       output.flush();
            
      int status = connection.getResponseCode();
      return status;
    }
}
