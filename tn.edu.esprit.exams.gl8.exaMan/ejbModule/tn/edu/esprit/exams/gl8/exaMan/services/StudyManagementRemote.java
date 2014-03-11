package tn.edu.esprit.exams.gl8.exaMan.services;

import java.util.Date;

import javax.ejb.Remote;

import tn.edu.esprit.exams.gl8.exaMan.domain.Exam;
import tn.edu.esprit.exams.gl8.exaMan.domain.Session;
import tn.edu.esprit.exams.gl8.exaMan.domain.Speciality;
import tn.edu.esprit.exams.gl8.exaMan.domain.Student;

@Remote
public interface StudyManagementRemote {

	boolean addStudent(Student student);

	boolean addSpeciality(Speciality speciality);

	boolean addExam(Exam exam);

	Student findStudentById(String idStudent);

	Exam findExamById(int idExam);

	boolean addSession(Date dateOfTheExam, Student studentFound, Exam examFound);

	Session findSession(Date dateOfTheExam, String idStudent, int idExam);

	boolean update(Session sessionfound);

}
