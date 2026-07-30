package in.strix.hibernateDemo.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            name = "student_age",
            nullable = false,
            length = 3
    )
    private int age;

    @Column(
            name = "student_email",
            unique = true,
            nullable = false,
            length = 200
    )
    private String email;

    @ElementCollection
    @CollectionTable(
            name = "student_addresses",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Address> addresses;

    public Student(long id, String name, int age, String email, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
//    @ElementCollection
//    @CollectionTable(
//            name = "student_skills",
//            joinColumns = @JoinColumn(name = "student_id")
//    )
//    private Set<String> skills;

//    public Set<String> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(Set<String> skills) {
//        this.skills = skills;
//    }



    //    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "current house no")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "current street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "current city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "current state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "current pincode")
//            ),
//    })
//    private Address currentAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNo",
//                    column = @Column(name = "permanent house no")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "permanent street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "permanent city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "permanent state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "permanent pincode")
//            ),
//    })
//    private Address permanentAddress;

//    public Student(long id, String name, int age, String email, Address currentAddress, Address permanentAddress) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.currentAddress = currentAddress;
//        this.permanentAddress = permanentAddress;
//    }

//    public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }

//    public Address getPermanentAddress() {
//        return permanentAddress;
//    }
//
//    public void setPermanentAddress(Address permanentAddress) {
//        this.permanentAddress = permanentAddress;
//    }

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
