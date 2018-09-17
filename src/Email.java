import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultMailboxCapacity = 1000;
    private int defaultpasslength = 10;
    private String alternateEmail;
    private String companyDirect = "company.com";

    // Constructor
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Asking for department and return the department
        this.department = setDepartment();

        // random password
        this.password = randomPassword(defaultpasslength);
        System.out.println("Your password is : " + this.password);

        // generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyDirect;
    }

    // Ask for department
    private String setDepartment() {

        System.out.print("New Worker: " + firstName + "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "account";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.defaultMailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePass(String password) {
        this.password = password;
    }

    public int getMailboxCapacity(){ return defaultMailboxCapacity; }
    public String getPassword() { return password; }
    public String getAlternateEmail() { return alternateEmail; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + defaultMailboxCapacity + " mb";
    }
}