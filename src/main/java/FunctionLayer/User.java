package FunctionLayer;


public class User {

    public User( String email, String password, String role, String name, String address, String zipCity, String phone) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.zipCity = zipCity;
        this.phone = phone;
    }

    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private String name;
    private String address;
    private String zipCity;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addresse) {
        this.address = addresse;
    }

    public String getZipCity() {
        return zipCity;
    }

    public void setZipCity(int zipCity) {
        zipCity = zipCity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

}
