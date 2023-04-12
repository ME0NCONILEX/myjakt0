package se.me0nly.jaktia0.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@jakarta.persistence.Entity
public class Hunter {

    @Id
    @GeneratedValue(generator = "UUID" )
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false)
    private String customerId;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "app_user_id")
    private AppUser userCredentials;  // must be reworked!  HELP!

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address shippingAddress; // must be reworked! HELP!


    public Hunter() {
    }

    public Hunter(String customerId, String firstName, String lastName, String email, AppUser userCredentials, Address shippingAddress) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userCredentials = userCredentials;
        this.shippingAddress = shippingAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUser getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(AppUser userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hunter hunter = (Hunter) o;
        return Objects.equals(getFirstName(), hunter.getFirstName()) && Objects.equals(getLastName(), hunter.getLastName()) && Objects.equals(getEmail(), hunter.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
