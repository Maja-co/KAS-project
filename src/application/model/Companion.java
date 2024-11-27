package application.model;

public class Companion {

    private String name;
    private int phoneNumber;

    // Konstruktør der tager både navn og telefonnummer
    public Companion(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Konstruktør der kun tager navn (telefonnummer kan sættes til en standardværdi)
    public Companion(String companionName) {
        this.name = companionName;
        this.phoneNumber = 0;  // Standard telefonnummer
    }

    // Getters og setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
