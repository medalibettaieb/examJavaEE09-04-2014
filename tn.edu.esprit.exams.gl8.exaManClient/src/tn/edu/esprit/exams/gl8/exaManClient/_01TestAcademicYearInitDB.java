package tn.edu.esprit.exams.gl8.exaManClient;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.exams.gl8.exaMan.domain.Exam;
import tn.edu.esprit.exams.gl8.exaMan.domain.Speciality;
import tn.edu.esprit.exams.gl8.exaMan.domain.Student;
import tn.edu.esprit.exams.gl8.exaMan.services.StudyManagementRemote;

public class _01TestAcademicYearInitDB {
	private Context context;
	private StudyManagementRemote studyManagementRemote;

	@Before
	public void setUpBeforeClass() {
		try {
			context = new InitialContext();
			studyManagementRemote = (StudyManagementRemote) context
					.lookup("ejb:/tn.edu.esprit.exams.gl8.exaMan/StudyManagement!tn.edu.esprit.exams.gl8.exaMan.services.StudyManagementRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInitSchool() {
		Student student = new Student();
		student.setIdStudent("123MT");
		student.setNameStudent("smarty");

		Student student2 = new Student();
		student2.setIdStudent("456FT");
		student2.setNameStudent("beauty");

		Student student3 = new Student();
		student3.setIdStudent("789ST");
		student3.setNameStudent("you");

		Speciality speciality = new Speciality("life");

		Exam exam = new Exam("family");
		Exam exam2 = new Exam("money");
		Exam exam3 = new Exam("socialSkills");

		// linking exams whith the speciality created
		List<Exam> exams = new ArrayList<Exam>();
		exams.add(exam);
		exams.add(exam2);
		exams.add(exam3);

		speciality.linkExams(exams);

		Assert.assertTrue(studyManagementRemote.addStudent(student));
		Assert.assertTrue(studyManagementRemote.addStudent(student2));
		Assert.assertTrue(studyManagementRemote.addStudent(student3));

		Assert.assertTrue(studyManagementRemote.addSpeciality(speciality));

	}

}
