/**
 * Patient Class:
 *  Contains information (e.g., ID, name, age, medical condition) that is used in the PatientManager and PatientManagerApp classes
 */
public class Patient {
    private int ID;
    private String name;
    private int age;
    private String medicalCondition;

    /**
     * Constructor, constructs a new instance of a patient
     * @param ID, patient ID
     * @param name, patient name
     * @param age, patient age
     * @param medicalCondition, patient condition
     */
    public Patient(int ID, String name, int age, String medicalCondition) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
    }

    /**
     * Getter
     * @return, ID: the ID of the patient
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter
     * @param ID, sets the new patient ID to the ID private variable
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter
     * @return name: the name of the patient
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name, sets the patient name to the private instance "name" variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return age : the age of the patient
     */
    public int getAge() {
        return age;
    }

    /**
     * setter
     * @param age, sets the new age of the patient to the private instance variable "age"
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter
     * @return medicalCondition: medical condition of the patient
     */
    public String getMedicalCondition() {
        return medicalCondition;
    }

    /**
     * Setter
     * @param medicalCondition, sets the patient's medical condition to the private instance variable "medicalCondition"
     */
    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    /**
     * Overrided method that returns the patient's information via a String
     * @return a String with the patient information
     */
    @Override
    public String toString() {
        return "ID: " + ID + "\nName: " + name + "\nAge: " + age + "\nMedical Condition: " + medicalCondition;
    }
}

