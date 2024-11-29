package org.example;

import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        //showMenu();

        Patient patient = new Patient("Aldo C", "mailaldo@test.com");
        System.out.println(patient);

//        patient.setPhoneNumber("1234567891");
//        System.out.println(patient.getPhoneNumber());
//
        Doctor doctor = new Doctor("Fifas", "fifas@gmail.com");
        doctor.addAvailableAppointment(new Date(), "11:00 am");
        doctor.addAvailableAppointment(new Date(), "12:30 pm");
        doctor.addAvailableAppointment(new Date(), "2:00 pm");
//
        //        System.out.println(doctor.getAvailableAppointments());
        System.out.println(doctor);
//
//        for(Doctor.AvailableAppointment aA : doctor.getAvailableAppointments()){
//            System.out.println(aA.getDate() + " " + aA.getTime());
//        }

    }
}