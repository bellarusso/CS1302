package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {
	private final String testFile = StudentDataPersistenceManager.FILE_LOCATION;
	
	@BeforeEach
    void setUp() throws Exception {
		File file = new File(this.testFile);
		if (file.exists()) {
			file.delete();
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		File file = new File(this.testFile);
		if (file.exists()) {
			file.delete();
		}
	}

	
	@Test
	void testSaveStudentDataNull() {
		assertThrows(IllegalArgumentException.class, ()->
		{StudentDataPersistenceManager.saveStudentData(null);
		});
	}
	
	@Test
     void testSaveEmtyArray() throws IOException {
		Student[] empty = new Student[0];
		StudentDataPersistenceManager.saveStudentData(empty);
		
		File file = new File(this.testFile);
		assertTrue(file.exists(), "checking that the file was created");
		assertEquals(0, file.length(), "File should be empty");
	}
	
	@Test
    void testSaveAndVerifyFiles() throws IOException {
		Student[] studentsToSave = {
				new Student("Bella", 80),
                new Student("Jacob", 50),
                new Student("Olivia", 90)
		};
		
		StudentDataPersistenceManager.saveStudentData(studentsToSave);
		
		File file = new File(this.testFile);
		assertTrue(file.exists(), "File should be created");
		assertTrue(file.length() > 0, "File should not be empty");
	}

}
