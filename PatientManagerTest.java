import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * PatientManagerTests: Creates JUnit Tests for the Patient and PatientManager classes
 */
public class PatientManagerTest {

    @Test
    public void testAddPatient() {
        PatientManager patientManager = new PatientManager();
        Patient patient = new Patient(1, "John Doe", 35, "Flu");
        patientManager.addPatient(patient);
        Assert.assertTrue(patientManager.retrievePatient(1) != null);
    }

    @Test
    public void testRemovePatient() {
        PatientManager patientManager = new PatientManager();
        Patient patient = new Patient(1, "John Doe", 35, "Flu");
        patientManager.addPatient(patient);
        Assert.assertTrue(patientManager.removePatient(1));
        Assert.assertNull(patientManager.retrievePatient(1));
    }

    @Test
    public void testRemoveNonExistentPatient() {
        PatientManager patientManager = new PatientManager();
        Assert.assertFalse(patientManager.removePatient(1));
    }

    @Test
    public void testRetrievePatient() {
        PatientManager patientManager = new PatientManager();
        Patient patient = new Patient(1, "John Doe", 35, "Flu");
        patientManager.addPatient(patient);
        Assert.assertEquals(patient, patientManager.retrievePatient(1));
    }

    @Test
    public void testRetrieveNonExistentPatient() {
        PatientManager patientManager = new PatientManager();
        Assert.assertNull(patientManager.retrievePatient(1));
    }

    @Test
    public void testSearchPatients() {
        PatientManager patientManager = new PatientManager();
        Patient patient = new Patient(1, "John Doe", 25, "Fever");
        patientManager.addPatient(patient);

        List<Patient> result = patientManager.searchPatients("John");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(patient, result.get(0));
    }

    @Test
    public void testSearchPatientsNoMatch() {
        PatientManager patientManager = new PatientManager();
        Patient patient = new Patient(1, "John Doe", 25, "Fever");
        patientManager.addPatient(patient);

        List<Patient> result = patientManager.searchPatients("Alice");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testConstructor() {
        Patient patient = new Patient(1, "John Doe", 25, "Fever");

        Assert.assertEquals(1, patient.getID());
        Assert.assertEquals("John Doe", patient.getName());
        Assert.assertEquals(25, patient.getAge());
        Assert.assertEquals("Fever", patient.getMedicalCondition());
    }

    @Test
    public void testGetName() {
        Patient patient = new Patient(1, "John Doe", 25, "Fever");
        Assert.assertEquals(1, patient.getID());
        Assert.assertEquals("John Doe", patient.getName());
        Assert.assertEquals(25, patient.getAge());
        Assert.assertEquals("Fever", patient.getMedicalCondition());
    }

    @Test
    public void testSetters() {
        Patient patient = new Patient(1, "John Doe", 25, "Fever");

        patient.setID(2);
        patient.setName("Jane Smith");
        patient.setAge(30);
        patient.setMedicalCondition("Headache");

        Assert.assertEquals(2, patient.getID());
        Assert.assertEquals("Jane Smith", patient.getName());
        Assert.assertEquals(30, patient.getAge());
        Assert.assertEquals("Headache", patient.getMedicalCondition());
    }

    @Test
    public void testToString() {
        Patient patient = new Patient(1, "John Doe", 25, "Fever");

        String expectedToString = "ID: 1\nName: John Doe\nAge: 25\nMedical Condition: Fever";
        Assert.assertEquals(expectedToString, patient.toString());
    }

    @Test
    public void testNotEquals() {
        Patient patient1 = new Patient(1, "John Doe", 25, "Fever");
        Patient patient2 = new Patient(2, "Jane Smith", 30, "Headache");

        Assert.assertNotEquals(patient1, patient2);
    }
}
