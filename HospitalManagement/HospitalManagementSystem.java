package HospitalManagement;
import java.util.*;

public class HospitalManagementSystem {

    // Patient class
    static class Patient {
        private String patientId;
        private String name;
        private int age;
        private String contactNumber;
        private List<String> medicalHistory;

        public Patient(String patientId, String name, int age, String contactNumber) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
            this.contactNumber = contactNumber;
            this.medicalHistory = new ArrayList<>();
        }

        public String getPatientId() {
            return patientId;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public List<String> getMedicalHistory() {
            return medicalHistory;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public void addMedicalRecord(String record) {
            medicalHistory.add(record);
        }

        public String displayDetails() {
            return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Contact: " + contactNumber;
        }
    }

    // Doctor class
    static class Doctor {
        private String doctorId;
        private String name;
        private String specialization;
        private List<Patient> patients;

        public Doctor(String doctorId, String name, String specialization) {
            this.doctorId = doctorId;
            this.name = name;
            this.specialization = specialization;
            this.patients = new ArrayList<>();
        }

        public String getDoctorId() {
            return doctorId;
        }

        public String getName() {
            return name;
        }

        public String getSpecialization() {
            return specialization;
        }

        public List<Patient> getPatients() {
            return patients;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public String displayDetails() {
            return "Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization;
        }
    }

    // Appointment class
    static class Appointment {
        private String appointmentId;
        private Doctor doctor;
        private Patient patient;
        private Date appointmentDate;

        public Appointment(String appointmentId, Doctor doctor, Patient patient, Date appointmentDate) {
            this.appointmentId = appointmentId;
            this.doctor = doctor;
            this.patient = patient;
            this.appointmentDate = appointmentDate;
        }

        public String displayDetails() {
            return "Appointment ID: " + appointmentId + ", Doctor: " + doctor.getName() + 
                   ", Patient: " + patient.getName() + ", Date: " + appointmentDate;
        }
    }

    // Main class for Hospital Management System
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Patient> patients = new HashMap<>();
        Map<String, Doctor> doctors = new HashMap<>();
        Map<String, Appointment> appointments = new HashMap<>();

        while (true) {
            System.out.println("1. Register Patient");
            System.out.println("2. Register Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patient Details");
            System.out.println("5. View Doctor Details");
            System.out.println("6. Update Patient Details");
            System.out.println("7. Update Doctor Details");
            System.out.println("8. Cancel Appointment");
            System.out.println("9. View All Appointments");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register Patient
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    patients.put(patientId, new Patient(patientId, name, age, contactNumber));
                    System.out.println("Patient registered successfully!");
                    break;

                case 2:
                    // Register Doctor
                    System.out.print("Enter Doctor ID: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String docName = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    doctors.put(doctorId, new Doctor(doctorId, docName, specialization));
                    System.out.println("Doctor registered successfully!");
                    break;

                case 3:
                    // Book Appointment
                    System.out.print("Enter Appointment ID: ");
                    String appointmentId = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    String appDoctorId = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String appPatientId = scanner.nextLine();
                    System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                    String dateStr = scanner.nextLine();
                    Date appointmentDate = java.sql.Date.valueOf(dateStr);
                    
                    Doctor doctor = doctors.get(appDoctorId);
                    Patient patient = patients.get(appPatientId);
                    
                    if (doctor != null && patient != null) {
                        Appointment appointment = new Appointment(appointmentId, doctor, patient, appointmentDate);
                        appointments.put(appointmentId, appointment);
                        doctor.addPatient(patient);
                        System.out.println("Appointment booked successfully!");
                    } else {
                        System.out.println("Invalid Doctor or Patient ID!");
                    }
                    break;

                case 4:
                    // View Patient Details
                    System.out.print("Enter Patient ID: ");
                    String viewPatientId = scanner.nextLine();
                    Patient viewPatient = patients.get(viewPatientId);
                    if (viewPatient != null) {
                        System.out.println(viewPatient.displayDetails());
                        System.out.println("Medical History: " + viewPatient.getMedicalHistory());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    // View Doctor Details
                    System.out.print("Enter Doctor ID: ");
                    String viewDoctorId = scanner.nextLine();
                    Doctor viewDoctor = doctors.get(viewDoctorId);
                    if (viewDoctor != null) {
                        System.out.println(viewDoctor.displayDetails());
                        System.out.println("Patients: ");
                        for (Patient p : viewDoctor.getPatients()) {
                            System.out.println(p.displayDetails());
                        }
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 6:
                    // Update Patient Details
                    System.out.print("Enter Patient ID to update: ");
                    String updatePatientId = scanner.nextLine();
                    Patient updatePatient = patients.get(updatePatientId);
                    if (updatePatient != null) {
                        System.out.print("Enter new Name: ");
                        updatePatient.setName(scanner.nextLine());
                        System.out.print("Enter new Age: ");
                        updatePatient.setAge(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Enter new Contact Number: ");
                        updatePatient.setContactNumber(scanner.nextLine());
                        System.out.println("Patient details updated successfully!");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 7:
                    // Update Doctor Details
                    System.out.print("Enter Doctor ID to update: ");
                    String updateDoctorId = scanner.nextLine();
                    Doctor updateDoctor = doctors.get(updateDoctorId);
                    if (updateDoctor != null) {
                        System.out.print("Enter new Name: ");
                        updateDoctor.setName(scanner.nextLine());
                        System.out.print("Enter new Specialization: ");
                        updateDoctor.setSpecialization(scanner.nextLine());
                        System.out.println("Doctor details updated successfully!");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 8:
                    // Cancel Appointment
                    System.out.print("Enter Appointment ID to cancel: ");
                    String cancelAppointmentId = scanner.nextLine();
                    Appointment cancelAppointment = appointments.remove(cancelAppointmentId);
                    if (cancelAppointment != null) {
                        System.out.println("Appointment canceled successfully!");
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 9:
                    // View All Appointments
                    System.out.println("All Scheduled Appointments:");
                    for (Appointment app : appointments.values()) {
                        System.out.println(app.displayDetails());
                    }
                    break;

                case 10:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}
