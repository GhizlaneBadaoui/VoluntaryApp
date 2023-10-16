package fr.insa.ws.model;

import java.sql.SQLException;

public class Volunteer {
    private String name;
    private String mail;
    private String PhoneNumber;
    private String address;

    public Volunteer(String name, String mail, String phoneNumber, String address) throws SQLException {
        VolunteerTable.addVolunteer(name,mail,phoneNumber,address);
        this.name = name;
        this.mail = mail;
        this.PhoneNumber = phoneNumber;
        this.address = address;
    }

    public static void RemoveVolunteer(String mail) throws SQLException {
        VolunteerTable.deleteVolunteer(mail);
    }

    public static void updateVolunteer(String mail, String name) throws SQLException {
        VolunteerTable.updateVolunteer(mail,name);
    }

    public static String getVolunteerInfo(String mail) throws SQLException {
        return VolunteerTable.getVolunteer(mail);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}