package bnm.bnmapi;
import javax.persistence.*;


//@Entity
//@Table(name = "userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String prefferedlocations;
    private String prefferedtimings;
    private String preffereddays;
    private String prefferedstores;
    private String address;
    private String gender;
    private String mobile_no;
    public UserProfile() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefferedlocations() {
        return prefferedlocations;
    }

    public void setPrefferedlocations(String prefferedlocations) {
        this.prefferedlocations = prefferedlocations;
    }

    public String getPrefferedtimings() {
        return prefferedtimings;
    }

    public void setPrefferedtimings(String prefferedtimings) {
        this.prefferedtimings = prefferedtimings;
    }

    public String getPreffereddays() {
        return preffereddays;
    }

    public void setPreffereddays(String preffereddays) {
        this.preffereddays = preffereddays;
    }

    public String getPrefferedstores() {
        return prefferedstores;
    }

    public void setPrefferedstores(String prefferedstores) {
        this.prefferedstores = prefferedstores;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserProfile(Integer userId,String name,String email,String mobile_no,String prefferedlocations,String preffereddays,String prefferedstores,String prefferedtimings,String address,String gender) {
        this.userId = userId;
        this.name=name;
        this.email = email;
        this.mobile_no=mobile_no;
        this.prefferedlocations = prefferedlocations;
        this.prefferedtimings = prefferedtimings;
        this.preffereddays = preffereddays;
        this.prefferedstores = prefferedstores;
        this.address = address;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "entity{" +
                "id='" + userId + '\'' +
                ",name='" + name + '\'' +
                ",email='" + email + '\'' +
                ",mobile_no='" + mobile_no + '\'' +
                ", preffered_locations='" + prefferedlocations + '\'' +
                ", preffered_timings=" + prefferedtimings +
                ", preffered_days=" + preffereddays +
                ", preffered_stores=" + prefferedstores +
                ", address=" + address +
                ", gender=" + gender +


                '}';
    }
}
