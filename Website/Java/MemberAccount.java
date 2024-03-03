import java.sql.*;

public class MemberAccount {
    private String memberEmail;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;


    // Constructor
    public BusinessAccount(String memberEmail, String firstName, String lastName,
                           String address, String city, String state, String zipCode, String phoneNumber) {
        this.memberEmail = memberEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    // Get and Set Functions
    public String getMemberEmail() {
        return memberEmail; }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;}

    public String getFirstName() {
        return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    public String getLastName() {
        return lastName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;}

    public String getAddress() {
        return address;}

    public void setAddress(String address) {
        this.address = address;}

    public String getCity() {
        return city;}

    public void setCity(String city) {
        this.city = city;}

    public String getState() {
        return state;}

    public void setState(String state) {
        this.state = state;}

    public String getZipCode() {
        return zipCode;}

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;}

    public String getPhoneNumber() {
        return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;}
}
