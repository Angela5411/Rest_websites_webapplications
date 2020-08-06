package data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "EXAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e")
    , @NamedQuery(name = "Exam.findByExamId", query = "SELECT e FROM Exam e WHERE e.examId = :examId")
    , @NamedQuery(name = "Exam.findByExamDate", query = "SELECT e FROM Exam e WHERE e.examDate = :examDate")
    , @NamedQuery(name = "Exam.findMax", query = "SELECT MAX(e.examId) FROM Exam e")})
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXAM_ID")
    private Integer examId;
    @Column(name = "EXAM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date examDate;
    @JoinColumn(name = "E_CENTER_ID", referencedColumnName = "E_CENTER_ID")
    @ManyToOne(optional = false)
    private ECenter eCenterId;

    public Exam() {
    }

    public Exam(Integer examId) {
        this.examId = examId;
    }

    public Exam(JsonObject json) throws ParseException
    {
        String examIdTemplate="examId";
        String examDateTemplate="examDate";
        String eCenterIdTemplate="ECenterId";
        
        this.eCenterId=new ECenter(json.getJsonObject(eCenterIdTemplate));
        if(json.containsKey(examIdTemplate))
            this.examId=json.getInt(examIdTemplate);
        if(json.containsKey(examDateTemplate))
        {
            SimpleDateFormat format=new SimpleDateFormat(json.getString(examDateTemplate));       
            this.examDate=format.parse(json.getString(examDateTemplate));
        }
        
    }
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
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
        if ((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Exam[ examId=" + examId + " ]";
    }
    
}
