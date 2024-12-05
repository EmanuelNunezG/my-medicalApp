package ui;

import org.modules.Doctor;
import org.modules.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Select the desired option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            response = Integer.valueOf(scanner().nextLine());
            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                    authUser(2);
                    response = 0;
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {
        //userType = 1 Doctor
        //userType = 2 Patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandra", "ale@test.com"));
        doctors.add(new Doctor("Sofia", "sofi@test.com"));
        doctors.add(new Doctor("Andrea", "andrea@test.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahi", "ana@test.com"));
        patients.add(new Patient("Zarah", "zarah@test.com"));
        patients.add(new Patient("Janet", "janet@test.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [q@q.com]");
            String email = scanner().nextLine();
            if (userType == 1) {
                System.out.println("Doctor");
                for (Doctor doctor : doctors) {
                    if (doctor.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Get the logged user
                        doctorLogged = doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            } else if (userType == 2) {
                System.out.println("Patient");
                for (Patient patient : patients) {
                    if (patient.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Get the logged user
                        patientLogged = patient;
                        showPatientMenu();
                    }
                }
            }
        } while (!emailCorrect);
    }

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");
            response = Integer.valueOf(scanner().nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + ". " + Month.values()[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }
}
