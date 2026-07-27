package in.strikes.CrudSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {
    @NotBlank(message = "name cannot be null/Empty or blank")
    @Size(min = 3, max = 50, message = "Student name must be 2 to 50 character long")
    private String name;

    @NotBlank(message = "Student email not be blank")
    @Email(message = "Student email must be valid")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be atleast 18")
    private Integer age;

    @NotNull(message = "Roll number is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
