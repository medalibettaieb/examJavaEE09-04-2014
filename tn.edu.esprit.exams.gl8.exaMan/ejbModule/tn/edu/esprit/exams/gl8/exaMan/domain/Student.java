package tn.edu.esprit.exams.gl8.exaMan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Student
 * 
 */
@Entity
@Table(name = "T_STUDENT")
public class Student implements Serializable {

	private String idStudent;
	private String nameStudent;
	private static final long serialVersionUID = 1L;

	private List<Session> sessions;

	public Student() {
		super();
	}

	@Id
	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return this.nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	@OneToMany(mappedBy = "student")
	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", nameStudent="
				+ nameStudent + ", sessions=" + sessions + "]";
	}
	

}
