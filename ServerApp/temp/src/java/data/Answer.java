package data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ANSWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
    , @NamedQuery(name = "Answer.findByIdA", query = "SELECT a FROM Answer a WHERE a.idA = :idA")
    , @NamedQuery(name = "Answer.findByAnswer", query = "SELECT a FROM Answer a WHERE a.answer = :answer")
    , @NamedQuery(name = "Answer.findByCorrect", query = "SELECT a FROM Answer a WHERE a.correct = :correct")
    , @NamedQuery(name = "Answer.findByTime", query = "SELECT a FROM Answer a WHERE a.time = :time")
    , @NamedQuery(name = "Answer.findByIdQIdP", query = "SELECT a FROM Answer a WHERE a.idP = :idP and a.idQ = :idQ")
    , @NamedQuery(name = "Answer.findMax", query = "SELECT MAX(a.idA) FROM Answer a")})

public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_A")
    private Integer idA;
    @Size(max = 45)
    @Column(name = "ANSWER")
    private String answer;
    @Size(max = 45)
    @Column(name = "CORRECT")
    private String correct;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "ID_P", referencedColumnName = "ID_P")
    @ManyToOne(optional = false)
    private Examinee idP;
    @JoinColumn(name = "ID_Q", referencedColumnName = "ID_Q")
    @ManyToOne(optional = false)
    private Question idQ;

    public Answer() {
    }

    public Answer(Integer idA, String answer, String correct, Date time, Examinee idP, Question idQ) {
        this.idA = idA;
        this.answer = answer;
        this.correct = correct;
        this.time = time;
        this.idP = idP;
        this.idQ = idQ;
    }
    
    public Answer(JsonObject json) throws ParseException 
    {
        String idATemplate="idA";
        String answerTemplate="answer";
        String correctTemplate="correct";
        String timeTemplate="time"; 
        String idPTemplate="idP";
        String idQTemplate="idQ";

        this.answer=json.getString(answerTemplate);
        this.correct=json.getString(correctTemplate);
        SimpleDateFormat format=new SimpleDateFormat(json.getString(timeTemplate));       
        this.time=format.parse(json.getString(timeTemplate));
        this.idP=new Examinee(json.getJsonObject(idPTemplate));
        this.idQ=new Question(json.getJsonObject(idQTemplate));
        
        if(json.containsKey(idATemplate))
            this.idA=json.getInt(idATemplate);
        

    }

    public Answer(Integer idA) {
        this.idA = idA;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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

    @Override
    public String toString() {
        return "data.Answer[ idA=" + idA + " ]";
    }
    
    
    
    
    
}
