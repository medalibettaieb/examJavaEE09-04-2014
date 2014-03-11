package tn.edu.esprit.exams.gl8.exaMan.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SessionIdentifire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentId;
	private int examId;
	private Date dateOfTheExam;

	public SessionIdentifire() {
		// TODO Auto-generated constructor stub
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionIdentifire other = (SessionIdentifire) obj;
		if (examId != other.examId)
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateOfTheExam() {
		return dateOfTheExam;
	}

	public void setDateOfTheExam(Date dateOfTheExam) {
		this.dateOfTheExam = dateOfTheExam;
	}

	public SessionIdentifire(Date dateOfTheExam, String studentId, int examId) {
		super();
		this.studentId = studentId;
		this.examId = examId;
		this.dateOfTheExam = dateOfTheExam;
	}

}
