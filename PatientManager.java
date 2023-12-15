import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PatientManager class
 * Manages the collection of patients
 * Provides methods to add, remove, and retrieve patient details.
 * No I/O operations should be in this class.
 */
public class PatientManager {
    private ArrayList<Patient> patients;

    /**
     * Constructor: Constructs a new instance of a PatientManager
     */
    public PatientManager() {
        this.patients = new ArrayList<>();
    }

    /**
     * Method used to add a new patient to the Array list
     * @param patient, patient
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
//    public void removePatient(int ID) {
//        patients.remove(ID);
//    }

    /**
     * Method used to remove a patient from the Array List
     * @param ID, the ID of the patient
     * @return boolean (true or false) to determine whether a patient has been removed
     */
    public boolean removePatient(int ID) {
    Iterator<Patient> iterator = patients.iterator(); //iterator is used to access elements (list, set, array
    while (iterator.hasNext()) {
        Patient patient = iterator.next();
        if (patient.getID() == ID) {
            iterator.remove();
            return true; // if the actul patient is removed, this return strues
        }
    }
    return false; // Patient not found
}

    /**
     * Method to retrieve patient information
     * @param patientID, the ID given to a patient
     * @return Patient
     */
    public Patient retrievePatient(int patientID) {
        for (Patient patient : patients) {
            if (patient.getID() == patientID) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Method used to search for a patient. it iterates through an array to find a search term which it thens prints out information from
     * @param searchTerm, the patient (ID or name) being searched for
     * @return List<Patient></Patient>
     */
    public List<Patient> searchPatients(String searchTerm) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            // Check if the search term matches either name or ID
            if (String.valueOf(patient.getID()).equals(searchTerm) || patient.getName().contains(searchTerm)) {
                result.add(patient);
            }
        }
        return result;
    }
}


