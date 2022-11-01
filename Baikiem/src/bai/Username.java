package bai;
public class Username {
    private String username;
    private String passwork;
    private String email;

    public Username(String username, String passwork, String email) {
        this.username = username;
        this.passwork = passwork;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}