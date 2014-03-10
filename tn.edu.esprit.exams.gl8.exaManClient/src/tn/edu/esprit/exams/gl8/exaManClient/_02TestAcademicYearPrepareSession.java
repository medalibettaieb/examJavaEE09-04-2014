package tn.edu.esprit.exams.gl8.exaManClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.exams.gl8.exaMan.domain.Exam;
import tn.edu.esprit.exams.gl8.exaMan.domain.Student;
import tn.edu.esprit.exams.gl8.exaMan.services.StudyManagementRemote;

public class _02TestAcademicYearPrepareSession {
	private Context context;
	private StudyManagementRemote studyManagementRemote;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
	public void testPrepareExams() throws ParseException {
		Student studentFound = studyManagementRemote.findStudentById("123MT");
		Student studentFound2 = studyManagementRemote.findStudentById("456FT");
		Student studentFound3 = studyManagementRemote.findStudentById("789ST");

		Exam examFound = studyManagementRemote.findExamById(1);
		Exam examFound2 = studyManagementRemote.findExamById(2);
		Exam examFound3 = studyManagementRemote.findExamById(3);

		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-01"), studentFound, examFound));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-02"), studentFound, examFound2));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-03"), studentFound, examFound3));

		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-01"), studentFound2, examFound));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-02"), studentFound2, examFound2));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-03"), studentFound2, examFound3));

		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-01"), studentFound3, examFound));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-02"), studentFound3, examFound2));
		Assert.assertTrue(studyManagementRemote.addSession(
				dateFormat.parse("2014-01-03"), studentFound3, examFound3));

	}

}
