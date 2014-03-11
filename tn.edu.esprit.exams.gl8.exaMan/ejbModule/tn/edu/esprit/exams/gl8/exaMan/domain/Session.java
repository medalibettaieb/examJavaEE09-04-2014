package tn.edu.esprit.exams.gl8.exaMan.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Mark
 * 
 */
@Entity
@Table(name = "T_Session")
public class Session implements Serializable {

	private SessionIdentifire markIdentifire;
	private float mark;
	private static final long serialVersionUID = 1L;

	private Student student;
	private Exam exam;

	public Session() {
		super();
	}

	@EmbeddedId
	public SessionIdentifire getMarkIdentifire() {
		return markIdentifire;
	}

	public void setMarkIdentifire(SessionIdentifire markIdentifire) {
		this.markIdentifire = markIdentifire;
	}

	public float getMark() {
		return this.mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@ManyToOne
	@JoinColumn(name = "studentId", referencedColumnName = "idStudent", insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "examId", referencedColumnName = "idExam", insertable = false, updatable = false)
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Session(Date dateOfTheExam, Student student, Exam exam) {
		super();
		this.setMarkIdentifire(new SessionIdentifire(dateOfTheExam,student.getIdStudent(), exam
				.getIdExam()));
		this.student = student;
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Session [markIdentifire=" + markIdentifire + ", mark=" + mark
				+ ", student=" + student + ", exam=" + exam + "]";
	}
	

}
