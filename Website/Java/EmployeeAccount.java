import java.sql.*;

public class EmployeeAccount {
    private int employeeId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    // Constructor
    public EmployeeAccount(int employeeId, String username, String firstName, String lastName, String email, String title) {
        this.employeeId = employeeId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

        // Getters
    public int getEmployeeId() {
        return employeeId;}

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;}    

    public String getUsername() {
        return username;}

    public void setUsername(String username) {
        this.username = username;}

    public String getFirstName() {
        return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    public String getLastName() {
        return lastName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;}

    public String getEmail() {
        return email;}

    public void setEmail(String email) {
        this.email = email;}    

    public String getTitle() {
        return title;}

    public void setTitle(String title) {
        this.title = title;}
}
