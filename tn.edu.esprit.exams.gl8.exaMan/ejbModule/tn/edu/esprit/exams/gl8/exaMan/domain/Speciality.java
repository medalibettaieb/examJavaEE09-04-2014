package tn.edu.esprit.exams.gl8.exaMan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Speciality
 * 
 */
@Entity
@Table(name = "T_SPECIALITY")
public class Speciality implements Serializable {

	private int idSpeciality;
	private String nameSpeciality;
	private static final long serialVersionUID = 1L;

	private List<Exam> exams;

	public Speciality() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdSpeciality() {
		return this.idSpeciality;
	}

	public void setIdSpeciality(int idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public String getNameSpeciality() {
		return this.nameSpeciality;
	}

	public void setNameSpeciality(String nameSpeciality) {
		this.nameSpeciality = nameSpeciality;
	}

	@OneToMany(mappedBy = "speciality", cascade = CascadeType.PERSIST)
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Speciality(String nameSpeciality) {
		super();
		this.nameSpeciality = nameSpeciality;
	}

	public void linkExams(List<Exam> exams) {
		this.exams = exams;
		for (Exam exam : exams) {
			exam.setSpeciality(this);

		}

	}

}
