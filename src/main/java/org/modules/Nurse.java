package org.modules;

public class Nurse extends User {
    //Attributes
    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
        System.out.println("Nurse Constructor Called with name as " + name);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "Nurse{" +
                "speciality='" + speciality + '\'' +
                '}';
    }
}
