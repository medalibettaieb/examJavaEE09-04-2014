package tn.edu.esprit.exams.gl8.exaMan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Exam
 * 
 */
@Entity
@Table(name = "T_EXAM")
public class Exam implements Serializable {

	private int idExam;
	private String titleExam;
	private static final long serialVersionUID = 1L;

	private Speciality speciality;
	private List<Session> sessions;

	public Exam() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdExam() {
		return this.idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	public String getTitleExam() {
		return this.titleExam;
	}

	public void setTitleExam(String titleExam) {
		this.titleExam = titleExam;
	}

	@ManyToOne
	@JoinColumn(name="speciality_FK")
	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Exam(String titleExam) {
		super();
		this.titleExam = titleExam;
	}

	@OneToMany(mappedBy = "exam")
	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Exam [idExam=" + idExam + ", titleExam=" + titleExam
				+ ", speciality=" + speciality + ", sessions=" + sessions + "]";
	}
	

}
