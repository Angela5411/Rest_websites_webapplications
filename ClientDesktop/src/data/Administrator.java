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
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String idPTemplate="idP";
    public static final String usernameTemplate="username";
    public static final String passwordHashTemplate="passwordHash";
    public static final String eCenterIdTemplate="ECenterId";
    @Id
    private Integer idP;
    private String username;
    private String passwordHash;
    private ECenter eCenter;

    public Administrator() {
    }

    public Administrator(Integer idP) {
        this.idP = idP;
    }

    public Administrator(Integer idP, String username,String password) {
        this.idP = idP;
        this.username = username;
        this.passwordHash=password;
    }
    
    public Administrator(String username,String password)
    {
        this.username=username;
        this.passwordHash=password;
    }
    
    public Administrator(JSONObject json) throws JSONException
    {
        this.passwordHash=json.getString(passwordHashTemplate);
        this.username=json.getString(usernameTemplate);
        if(json.has(eCenterIdTemplate))
            this.eCenter=new ECenter (json.getJSONObject(eCenterIdTemplate));
        if(json.has(idPTemplate))
            this.idP=json.getInt(idPTemplate);
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
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

    public ECenter getECenterId() {
        return eCenter;
    }

    public void setECenterId(ECenter eCenter) {
        this.eCenter = eCenter;
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
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        return !((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP)));
    }

    @Override
    public String toString() {
        String result="Administrator: idP= " + idP +  " username= "+username;
        if(eCenter!=null)
            result=result+" ECenter= "+ eCenter.getECenterName();
        return result;
            
    }
    
    public void existsUsername() throws JSONException, MalformedURLException,IOException
    {  
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/username/"+username);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);        

        if (json!=JSONObject.NULL) 
        {
             if(passwordHash.equals(json.getString(passwordHashTemplate)))
             {
                idP=json.getInt(idPTemplate); 
                try{
                eCenter=new ECenter(json.getJSONObject(eCenterIdTemplate));
                }catch(JSONException | java.lang.NullPointerException e )
                {
                    eCenter=null;
                }
            }
        }
        
    }
    public  Administrator findbyUsername(String name) throws JSONException, MalformedURLException, IOException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/username/"+name);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Administrator temp=new Administrator(json);        
            return temp;
        }
        return null;
    }
    
    public  Administrator findbyId(Integer id) throws JSONException, MalformedURLException, IOException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/"+id);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Administrator temp=new Administrator(json);        
            return temp;
        }
        return null;
    } 
    public Administrator findbyECenter(Integer eid) throws MalformedURLException, IOException, JSONException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/findbyecenterid/"+eid);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Administrator temp=new Administrator(json);        
            return temp;
        }
        return null;
    }
    public Administrator findbyECenter(String name) throws MalformedURLException, IOException, JSONException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/findbyecentername"+name);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            Administrator temp=new Administrator(json);        
            return temp;
        }
        return null;
    }
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idPTemplate,idP);
        json.put(usernameTemplate,username);
        json.put(passwordHashTemplate,passwordHash);
        if(this.eCenter!=null)
            json.put(eCenterIdTemplate,eCenter.toJSONObject());
        return json;
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(idPTemplate,this.idP);
        json.put(usernameTemplate,this.username);
        json.put(passwordHashTemplate,this.passwordHash);
        json.put(eCenterIdTemplate,this.eCenter);
        return json.toString();
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);
        //json.put(DateTemplate,dateString);
    }
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator");   
        POSTrequest(this.toJSONObject(),url);
    }
    
    public void updateAdministrator() throws MalformedURLException, JSONException, IOException, URISyntaxException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.administrator/updateadministrator");
        JSONObject json=this.toJSONObject();
        POSTrequest(json,url);
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
        System.out.print(content.toString());

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
