/*
        Author: Nabeel Meyers
        Student Number: 218328702
        Student.java
        Assignment 3
        2021
 */
package za.ac.cput.ADP3LabBookingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Student(){

    }

    private Student(Builder builder) {
        this.studentNumber = builder.studentNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static class Builder{

        private String studentNumber;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;

        //setters
        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() {

            return new Student(this);
        }

        public Builder copy(Student student) {
            this.studentNumber = student.studentNumber;
            this.firstName = student.firstName;
            this.lastName= student.lastName;
            this.email = student.email;
            this.phoneNumber = student.phoneNumber;

            return this;
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber = " + studentNumber +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", phone number = "+ phoneNumber +
                '}';
    }
}
