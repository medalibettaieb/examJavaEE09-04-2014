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

import tn.edu.esprit.exams.gl8.exaMan.domain.Session;
import tn.edu.esprit.exams.gl8.exaMan.services.StudyManagementRemote;

public class _03TestAcademicYearAssignMarks {
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
	public void testAssignMark() throws ParseException {
		Session sessionfound = studyManagementRemote.findSession(
				dateFormat.parse("2014-01-01"), "123MT", 1);

		Session sessionfound2 = studyManagementRemote.findSession(
				dateFormat.parse("2014-01-01"), "456FT", 1);

		Session sessionfound3 = studyManagementRemote.findSession(
				dateFormat.parse("2014-01-01"), "789ST", 1);

		sessionfound.setMark(12.5F);
		sessionfound2.setMark(10.5F);
		sessionfound3.setMark(19.75F);

		Assert.assertTrue(studyManagementRemote.update(sessionfound));
		Assert.assertTrue(studyManagementRemote.update(sessionfound2));
		Assert.assertTrue(studyManagementRemote.update(sessionfound3));

	}
}
