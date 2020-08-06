package data;

import java.io.Serializable;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "E_CENTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECenter.findAll", query = "SELECT e FROM ECenter e")
    , @NamedQuery(name = "ECenter.findByECenterId", query = "SELECT e FROM ECenter e WHERE e.eCenterId = :eCenterId")
    , @NamedQuery(name = "ECenter.findByECenterName", query = "SELECT e FROM ECenter e WHERE e.eCenterName = :eCenterName")
    , @NamedQuery(name = "ECenter.findByECenterAddress", query = "SELECT e FROM ECenter e WHERE e.eCenterAddress = :eCenterAddress")})
public class ECenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "E_CENTER_ID")
    private Integer eCenterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_CENTER_NAME")
    private String eCenterName;
    @Size(max = 45)
    @Column(name = "E_CENTER_ADDRESS")
    private String eCenterAddress;

    public ECenter() {
    }
    public ECenter(JsonObject json)
    {
        String eCenterIdTemplate="ECenterId";
        String eCenterNameTemplate="ECenterName";
        String eCenterAddressTemplate="ECenterAddress";
        
        
        this.eCenterAddress=json.getString(eCenterAddressTemplate);
        this.eCenterName=json.getString(eCenterNameTemplate);        
        try{
            this.eCenterId=json.getInt(eCenterIdTemplate);
        }catch(JsonException | java.lang.NullPointerException e )
        {;}


    }

    public ECenter(Integer eCenterId) {
        this.eCenterId = eCenterId;
    }

    public ECenter(Integer eCenterId, String eCenterName) {
        this.eCenterId = eCenterId;
        this.eCenterName = eCenterName;
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
        if ((this.eCenterId == null && other.eCenterId != null) || (this.eCenterId != null && !this.eCenterId.equals(other.eCenterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.ECenter[ eCenterId=" + eCenterId + " ]";
    }
    
}
