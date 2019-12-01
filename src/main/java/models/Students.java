package models;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "YearBirth")
    private int yearBirth;

    @Override
    public String toString() {
        return id+" "+name +" "+ lastName +" "+ yearBirth ;
    }

    public Students(String name, String lastName, int yearBirth) {
        this.name = name;
        this.lastName = lastName;
        this.yearBirth = yearBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Students() {
    }

    public Students(int id, String name, String lastName, int yearBirth) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.yearBirth = yearBirth;
    }
}

