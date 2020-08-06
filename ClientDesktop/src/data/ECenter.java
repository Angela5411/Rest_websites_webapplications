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
public class ECenter implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String eCenterIdTemplate="ECenterId";
    public static final String eCenterNameTemplate="ECenterName";
    public static final String eCenterAddressTemplate="ECenterAddress";    
    @Id
    private Integer eCenterId;
    private String eCenterName;
    private String eCenterAddress;
    

    public ECenter() {
    }

    public ECenter(Integer eCenterId) {
        this.eCenterId = eCenterId;
    }

    public ECenter(JSONObject json) throws JSONException
    {
        if(json.has(eCenterIdTemplate))
            eCenterId=json.getInt(eCenterIdTemplate);
        eCenterName=json.getString(eCenterNameTemplate);
        eCenterAddress=json.getString(eCenterAddressTemplate);        
    }
    public ECenter(Integer eCenterId, String eCenterName, String eCenterAddress) {
        this.eCenterId = eCenterId;
        this.eCenterName = eCenterName;
        this.eCenterAddress=eCenterAddress;
    }

    public ECenter(String c_name, String c_address) 
    {
        this.eCenterAddress=c_address;
        this.eCenterName=c_name;
    }

    public Integer getECenterId() {
        return eCenterId;
    }

    public void setECenterId(Integer eCenterId) {
        this.eCenterId = eCenterId;
    }

    public String getECenterName() {
        return eCenterName;
    }

    public void setECenterName(String eCenterName) {
        this.eCenterName = eCenterName;
    }

    public String getECenterAddress() {
        return eCenterAddress;
    }

    public void setECenterAddress(String eCenterAddress) {
        this.eCenterAddress = eCenterAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eCenterId != null ? eCenterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ECenter)) {
            return false;
        }
        ECenter other = (ECenter) object;
        return !((this.eCenterId == null && other.eCenterId != null) || (this.eCenterId != null && !this.eCenterId.equals(other.eCenterId)));
    }

    
    
    public JSONObject toJSONObject()throws JSONException
    {
        JSONObject json=new JSONObject();
        if(this.eCenterId!=null)
            json.put(eCenterIdTemplate,eCenterId);
        json.put(eCenterNameTemplate,eCenterName);
        json.put(eCenterAddressTemplate,eCenterAddress);
        return json;
        
    }
    
    public String toJSON()throws JSONException
    {
        JSONObject json=new JSONObject();
        json.put(eCenterIdTemplate,this.eCenterId);
        json.put(eCenterNameTemplate,this.eCenterName);
        json.put(eCenterAddressTemplate,this.eCenterAddress);
        return json.toString();
        
        //SimpleDataFormat format=new SimpleDataFormat(DateTemolate);
        //String dateString=format.format(Date);        
    }
    
    
    static public List<ECenter> findAll() throws JSONException, MalformedURLException, IOException
    {  
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.ecenter");
        String request=GETrequest(url);
        JSONArray arr=new JSONArray(request);
        List<ECenter> eCenters=new ArrayList<ECenter>();
        if (arr!=JSONObject.NULL) 
        {
            for (int i = 0; i < arr.length(); i++) 
            { // Walk through the Array.
                JSONObject obj = arr.getJSONObject(i);
                ECenter temp=new ECenter(obj);
                eCenters.add(temp);
            }       
            return eCenters;
        }
        return null;        
    }
    
    public  ECenter findbyΝame(String name) throws JSONException, MalformedURLException, IOException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.ecenter/ecentername/"+name);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            ECenter temp=new ECenter(json);        
            return temp;
        }
        return null;
    }
    
    public  ECenter findbyId(Integer id) throws JSONException, MalformedURLException, IOException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.ecenter/"+id);
        String request=GETrequest(url);
        JSONObject json=new JSONObject(request);
        if (json!=JSONObject.NULL) 
        {
            ECenter temp=new ECenter(json);        
            return temp;
        }
        return null;
    }
    
    
    public void updateECenter() throws MalformedURLException, JSONException, IOException, URISyntaxException
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.ecenter/updateecenter");
        JSONObject json=this.toJSONObject();
        POSTrequest(json,url);
    }
    
    public  void terminate() throws MalformedURLException, JSONException, IOException, URISyntaxException 
    {
        URL url = new URL("http://localhost:8080/ServerApp/webresources/data.ecenter");   
        POSTrequest(this.toJSONObject(),url);
        
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
       output = new DataOutputStream(connection.getOutputStream());
       output.writeChars(arr.toString());
       output.flush();
            
      int status = connection.getResponseCode();
    }
}
