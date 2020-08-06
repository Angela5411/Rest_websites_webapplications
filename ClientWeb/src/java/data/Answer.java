package data;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.ws.rs.Produces;
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

    public Answer(JSONObject json) throws JSONException
    {
        this.answer=json.getString(answerTemplate);
        this.correct=json.getString(answerTemplate);
        this.idQ=new Question(json.getJSONObject(idQTemplate));
        this.idP=new Examinee(json.getJSONObject(idPTemplate));
        if(json.has(idATempate))
            this.idA=json.getInt(idATempate);
        if(json.has(timeTemplate))
        {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(json.getString(timeTemplate).substring(0, 19), formatter);
                this.time=dateTime;
            
            
        }
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
        json.put(idPTemplate,this.idP);
        json.put(idQTemplate,this.idQ);
        
        return json.toString();
    }
      
      public void existsAnswer() throws JSONException, IOException
    {  
        
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.answer/max");
        JSONObject json=new JSONObject(target.request(MediaType.APPLICATION_JSON).get(String.class));
        
        if (json!=JSONObject.NULL) 
        {
            Integer max=json.getInt("");
        }
    }
      
    public static List<Answer> findAll() throws JSONException
    {
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.answer");
        JSONArray arr=new JSONArray(target.request(MediaType.APPLICATION_JSON).get(String.class));
        
        List<Answer> answers=new ArrayList<Answer>();
        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                Answer temp=new Answer(obj);
                answers.add(temp);
            }       
            return answers;
        }
        return null;        
    }
    
    public static List<Answer> findbyExaminee(Integer id) throws JSONException
    {
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/ServerApp/webresources/data.answer/findbyexaminee/"+id);
        JSONArray arr=new JSONArray(target.request(MediaType.APPLICATION_JSON).get(String.class));
        
        List<Answer> answers=new ArrayList<Answer>();
        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                Answer temp=new Answer(obj);
                answers.add(temp);
            }       
            return answers;
        }
        return null;    
    }
}
