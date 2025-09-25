package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSaveStudentData {
  public static final String testFile = "data.txt";

  @BeforeEach
  void setUp() throws Exception {
    File file = new File(TestSaveStudentData.testFile);
    if (file.exists()) {
      file.delete();
    }
  }

  @AfterEach
  void tearDown() throws Exception {
    File file = new File(TestSaveStudentData.testFile);
    {
      file.delete();
    }
  }

  @Test
  void testSaveStudentDataNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      StudentDataPersistenceManager.saveStudentData(null);
    });
  }

  @Test
  void testSaveEmptyArray() throws IOException {
    Student[] empty = new Student[0];
    StudentDataPersistenceManager.saveStudentData(empty);

    File file = new File(TestSaveStudentData.testFile);
    assertTrue(file.exists(), "checking that the file was created");
    assertEquals(0, file.length(), "File should be empty");
  }

  @Test
  void testSaveAndVerifyFiles() throws IOException {
    Student[] studentsToSave = { new Student("Bella", 80), 
        new Student("Jacob", 50), new Student("Olivia", 90) };

    StudentDataPersistenceManager.saveStudentData(studentsToSave);

    File file = new File(TestSaveStudentData.testFile);
    assertTrue(file.exists(), "File should be created");
    assertTrue(file.length() > 0, "File should not be empty");
  }

  @Test
  void testSaveAndOutputContents() throws IOException {
    Student[] studentsToSave = { new Student("Bella", 80), new Student("Jacob", 50) };
    StudentDataPersistenceManager.saveStudentData(studentsToSave);
    Student[] loadedStudents = StudentDataPersistenceManager.loadStudentData();
    assertEquals(2, loadedStudents.length);
    assertEquals("Bella", loadedStudents[0].getName());
    assertEquals(80, loadedStudents[0].getGrade());
    assertEquals("Jacob", loadedStudents[1].getName());
    assertEquals(50, loadedStudents[1].getGrade());
  }

}
