
package data;

import java.io.Serializable;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ADMINISTRATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
    , @NamedQuery(name = "Administrator.findByIdP", query = "SELECT a FROM Administrator a WHERE a.idP = :idP")
    , @NamedQuery(name = "Administrator.findByUsername", query = "SELECT a FROM Administrator a WHERE a.username = :username")
    , @NamedQuery(name = "Administrator.findByPasswordHash", query = "SELECT a FROM Administrator a WHERE a.passwordHash = :passwordHash")
})
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_P")
    private Integer idP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 45)
    @Column(name = "PASSWORD_HASH")
    private String passwordHash;
    @JoinColumn(name = "E_CENTER_ID", referencedColumnName = "E_CENTER_ID")
    @ManyToOne
    private ECenter eCenterId;

    public Administrator() {
    }

    public Administrator(JsonObject json)
    {
        String idPTemplate="idP";
        String usernameTemplate="username";
        String passwordHashTemplate="passwordHash";
        String eCenterIdTemplate="ECenterId";
        
        this.passwordHash=json.getString(passwordHashTemplate);
        this.username=json.getString(usernameTemplate);
        if(json.containsKey(eCenterIdTemplate))
            this.eCenterId=new ECenter(json.getJsonObject(eCenterIdTemplate));
        if(json.containsKey(idPTemplate))
            this.idP=json.getInt(idPTemplate);        
       
    }
    public Administrator(Integer idP) {
        this.idP = idP;
    }

    public Administrator(Integer idP, String username) {
        this.idP = idP;
        this.username = username;
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
        return eCenterId;
    }

    public void setECenterId(ECenter eCenterId) {
        this.eCenterId = eCenterId;
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
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Administrator[ idP=" + idP + " ]";
    }
    
}
