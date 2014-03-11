package tn.edu.esprit.exams.gl8.exaMan.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.exams.gl8.exaMan.domain.Exam;
import tn.edu.esprit.exams.gl8.exaMan.domain.Session;
import tn.edu.esprit.exams.gl8.exaMan.domain.SessionIdentifire;
import tn.edu.esprit.exams.gl8.exaMan.domain.Speciality;
import tn.edu.esprit.exams.gl8.exaMan.domain.Student;

/**
 * Session Bean implementation class StudyManagement
 */
@Stateless
public class StudyManagement implements StudyManagementRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StudyManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addStudent(Student student) {
		boolean b = false;
		try {
			entityManager.persist(student);
			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}

	@Override
	public boolean addSpeciality(Speciality speciality) {
		boolean b = false;
		try {
			entityManager.persist(speciality);
			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}

	@Override
	public boolean addExam(Exam exam) {
		boolean b = false;
		try {
			entityManager.persist(exam);
			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}

	@Override
	public Student findStudentById(String idStudent) {
		Student student = new Student();
		String jpqlQuery = "select s from Student s where s.idStudent='"
				+ idStudent + "'";
		Query query = entityManager.createQuery(jpqlQuery);
		try {
			student = (Student) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("no entity found for query ");
		}

		return student;

	}

	@Override
	public Exam findExamById(int idExam) {
		Exam examFound = new Exam();
		try {
			examFound = entityManager.find(Exam.class, idExam);
		} catch (Exception e) {
			System.err.println("exam not found");
		}
		return examFound;
	}

	@Override
	public boolean addSession(Date dateOfTheExam, Student studentFound,
			Exam examFound) {
		boolean b = false;
		try {
			Session session = new Session(dateOfTheExam, studentFound,
					examFound);
			entityManager.persist(session);
			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}

	@Override
	public Session findSession(Date dateOfTheExam, String idStudent, int idExam) {
		Session sessionFound = new Session();
		System.out.println(1111);

		SessionIdentifire sessionIdentifire = new SessionIdentifire(
				dateOfTheExam, idStudent, idExam);

		sessionFound = entityManager.find(Session.class, sessionIdentifire);
		System.out.println(sessionIdentifire.getDateOfTheExam());
		System.out.println(2222);

		return sessionFound;
	}

	@Override
	public boolean update(Session sessionfound) {
		boolean b = false;
		try {
			entityManager.merge(sessionfound);
			b = true;
		} catch (Exception e) {
			System.err.println("oops ...");
		}
		return b;
	}
}
