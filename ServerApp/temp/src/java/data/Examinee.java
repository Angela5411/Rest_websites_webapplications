package data;

import java.io.Serializable;
import java.text.ParseException;
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
@Table(name = "EXAMINEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examinee.findAll", query = "SELECT e FROM Examinee e")
    , @NamedQuery(name = "Examinee.findByIdP", query = "SELECT e FROM Examinee e WHERE e.idP = :idP")
    , @NamedQuery(name = "Examinee.findByName", query = "SELECT e FROM Examinee e WHERE e.name = :name")
    , @NamedQuery(name = "Examinee.findByUsername", query = "SELECT e FROM Examinee e WHERE e.username = :username")
    , @NamedQuery(name = "Examinee.findByPasswordHash", query = "SELECT e FROM Examinee e WHERE e.passwordHash = :passwordHash")})
public class Examinee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_P")
    private Integer idP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 45)
    @Column(name = "PASSWORD_HASH")
    private String passwordHash;
    @JoinColumn(name = "EXAM_ID", referencedColumnName = "EXAM_ID")
    @ManyToOne(optional = false)
    private Exam examId;

    public Examinee() {
    }

    public Examinee(Integer idP) {
        this.idP = idP;
    }

    public Examinee(JsonObject json) throws ParseException
    {
        String idPTemplate="idP";
        String nameTemplate="name";
        String usernameTemplate="username";
        String passwordHashTemplate="passwordHash";
        String examIdTemplate="examId";
                
        this.name=json.getString(nameTemplate);
        this.username=json.getString(usernameTemplate);
        this.passwordHash=json.getString(passwordHashTemplate);
        if(json.containsKey(idPTemplate))
            this.idP=json.getInt(idPTemplate);        
        if(json.containsKey(examIdTemplate))
            this.examId=new Exam(json.getJsonObject(examIdTemplate));        
           
    }
    public Examinee(Integer idP, String name, String username) {
        this.idP = idP;
        this.name = name;
        this.username = username;
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

    public void setExamId( Exam examId) {
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

    
    
}
