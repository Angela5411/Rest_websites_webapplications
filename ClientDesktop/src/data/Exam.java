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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String examIdTemplate="examId";
    public static final String examDateTemplate="examDate";
    public static final String eCenterIdTemplate="ECenterId";

    
    @Id
    private Integer examId;
    private LocalDateTime examDate;
    private ECenter eCenterId;

    public Exam() {
    }

    public Exam(Integer examId) {
        this.examId = examId;
    }

    public Exam(JSONObject json) throws JSONException
    {
        if(json.has(examIdTemplate))
            this.examId=json.getInt(examIdTemplate);
        if(json.has(eCenterIdTemplate))
            this.eCenterId=new ECenter(json.getJSONObject(eCenterIdTemplate));
        if(json.has(examDateTemplate))
        {      
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(json.getString(examDateTemplate).substring(0, 19), formatter);
            this.examDate=dateTime;
        }
        //System.out.println(" "+this.eCenterId.getECenterName()+this.examDate+this.examId);
        
        
    }
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public ECenter getECenterId() {
        return eCenterId;
    }

    public void setECenterId(ECenter eCenterId) {
        this.eCenterId = eCenterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examId != null ? examId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        return !((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId)));
    }

    @Override
    public String toString() {
        return "data.Exam[ examId=" + examId + " ]";
    }
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        if(this.examId!=null)
            json.put(examIdTemplate,examId);
        json.put(eCenterIdTemplate,eCenterId.toJSONObject());
        
        if(this.examDate!=null)
        {
            String date=this.examDate.toLocalDate()+" "+this.examDate.toLocalTime();        
            json.put(examDateTemplate,date);

        }
        return json;
    }
    
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(examIdTemplate,this.examId);
        json.put(eCenterIdTemplate,this.eCenterId);
        SimpleDateFormat format=new SimpleDateFormat(examDateTemplate);
        String dateString=format.format(this.examDate);
        json.put(examDateTemplate,dateString); 
        return json.toString();
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
    public static List<Exam> findAll() throws JSONException, IOException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.exam");
        String request=GETrequest(url);
        JSONArray arr=new JSONArray(request);
        List<Exam> exams=new ArrayList<Exam>();
        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                Exam temp=new Exam(obj);
                exams.add(temp);
            }       
            return exams;
        }
        return null; 
    }
    
    
    public  Exam findbyId(Integer id) throws JSONException, MalformedURLException, IOException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.exam/"+id);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Exam temp=new Exam(json);        
            return temp;
        }
        return null;
    }
    public Integer findMax() throws MalformedURLException, IOException, JSONException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.exam/max");
        String request=GETrequest(url);
        return Integer.parseInt(request);
    }
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.exam");   
        POSTrequest(this.toJSONObject(),url);
        
    }
    public void updateExam() throws MalformedURLException, JSONException, IOException, URISyntaxException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.exam/updateexam");
        JSONObject json=this.toJSONObject();
        POSTrequest(json,url);
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
