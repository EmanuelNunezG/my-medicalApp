package ui;

import org.modules.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an Appointment");
                    showBookAppointmentMenu();
                    break;
                case 2:
                    System.out.println("::My Appointments");
                    showPatientAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an Appointment");
            System.out.println(":: Select Date: ");
            //Numeration of the dates
            //Indice de la lista de fechas
            // [doctors]
            // 1.- doctor1
            // - doctor2
            // - doctor3
            // 2. Select doctor:
            // [date]
            // 1.- dia1
            // - dia2
            // - dia3
            // 3.- dia4
            // 0.- Return
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments =
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer doctorKey = 0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                doctorKey = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(doctorKey).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(doctorKey).getTime());
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Date");

            response = Integer.valueOf(sc.nextLine());
                if (response == 1) {
                    UIMenu.patientLogged.addAppointmentDoctors(
                            doctorSelected,
                            doctorSelected.getAvailableAppointments().get(doctorKey).getDate(),
                            doctorSelected.getAvailableAppointments().get(doctorKey).getTime());

                    showPatientMenu();
                }
        } while (response != 0);
    }
    private static void showPatientAppointments() {
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        } while (response != 0);
    }
}