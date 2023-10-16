package fr.insa.ws.model;

import java.sql.SQLException;

public class Requester {
    private String name;
    private String mail;
    private String PhoneNumber;
    private String address;
    
    public Requester(String name, String mail, String phoneNumber, String address) throws SQLException {
        RequesterTable.addRequester(name,mail,phoneNumber,address);
        this.name = name;
        this.mail = mail;
        this.PhoneNumber = phoneNumber;
        this.address = address;
    }

    public Requester() {
    }

    public static void RemoveRequester(String mail) throws SQLException {
        RequesterTable.deleteRequester(mail);
    }

    public static void updateRequester(String mail, String name) throws SQLException {
        RequesterTable.updateRequester(mail,name);
    }

    public static String getRequesterInfo(String mail) throws SQLException {
        return RequesterTable.getRequester(mail);
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
        return "Requester{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}