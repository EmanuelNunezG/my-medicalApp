package org.modules;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Attributes
    private String speciality;

    public Doctor(String name, String email) {
        super(name, email);
        System.out.println("Doctor Constructor Called with name as " + name);
    }

    @Override
    public void showDataUser() {
        System.out.println("Employee Hospital: Cruz Roja");
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time) {
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" +
                "speciality='" + speciality + '\'' +
                "availableAppointments='" + availableAppointments.toString() + '\'' +
                '}';
    }

    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "AvailableAppointment{" +
                    "id=" + id +
                    ", date=" + date +
                    ", time='" + time + '\'' +
                    '}';
        }
    }
}


