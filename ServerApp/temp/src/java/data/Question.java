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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findByIdQ", query = "SELECT q FROM Question q WHERE q.idQ = :idQ")
    , @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question")
    , @NamedQuery(name = "Question.findByA1", query = "SELECT q FROM Question q WHERE q.a1 = :a1")
    , @NamedQuery(name = "Question.findByA2", query = "SELECT q FROM Question q WHERE q.a2 = :a2")
    , @NamedQuery(name = "Question.findByA3", query = "SELECT q FROM Question q WHERE q.a3 = :a3")
    , @NamedQuery(name = "Question.findByA4", query = "SELECT q FROM Question q WHERE q.a4 = :a4")
    , @NamedQuery(name = "Question.findByCorrect", query = "SELECT q FROM Question q WHERE q.correct = :correct")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Q")
    private Integer idQ;
    @Size(max = 500)
    @Column(name = "QUESTION")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "A1")
    private String a1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "A2")
    private String a2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "A3")
    private String a3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "A4")
    private String a4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRECT")
    @Pattern(regexp="^[1234]&")
    private int correct;
    
    public Question() {
    }

    public Question(Integer idQ) {
        this.idQ = idQ;
    }

    public Question(Integer idQ, String a1, String a2, String a3, String a4, int correct) {
        this.idQ = idQ;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correct = correct;
    }
    public Question(JsonObject json)
    {
        String idQTemplate="idQ";
        String questionTemplate="question";
        String a1Template="a1";
        String a2Template="a2";
        String a3Template="a3";
        String a4Template="a4";
        String correctTemplate="correct";
        
        
        this.a1=json.getString(a1Template);
        this.a2=json.getString(a2Template);
        this.a3=json.getString(a3Template);
        this.a4=json.getString(a4Template);
        this.correct=json.getInt(correctTemplate);
        this.question=json.getString(questionTemplate);
        try{
            this.idQ=json.getInt(idQTemplate);
        }catch(JsonException | java.lang.NullPointerException e )
        {;}


    }
    

    public Integer getIdQ() {
        return idQ;
    }
    

    public void setIdQ(Integer idQ) {
        this.idQ = idQ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQ != null ? idQ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQ == null && other.idQ != null) || (this.idQ != null && !this.idQ.equals(other.idQ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Question[ idQ=" + idQ + " ]";
    }
    
}
