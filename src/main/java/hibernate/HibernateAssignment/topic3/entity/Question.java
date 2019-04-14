package hibernate.HibernateAssignment.topic3.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {

	private Integer id;
	private String qname;
	private String answer;
	private List<MultiOptions> options;
	
	public Question() {
		
	}
	
	public Question(String qname, String answer,List<MultiOptions> options) {
		
		this.qname = qname;
		this.answer = answer;
		this.options = options;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="qname")
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@ElementCollection
	@CollectionTable(name="MultiOptions", joinColumns=@JoinColumn(name="Question_Id"))
	@AttributeOverrides({
        @AttributeOverride(name = "options", column = @Column(name = "options")),
	})
	public List<MultiOptions> getOptions() {
		return options;
	}
	public void setOptions(List<MultiOptions> options) {
		this.options = options;
	}

}
