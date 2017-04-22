package com.none;

import javax.persistence.*;

@Entity
@Table(name = "job")
@Access(AccessType.FIELD)
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="j_name")
    private String jobName;

    @Column(name="salary")
    private Integer salary;

    @OneToOne(mappedBy = "job", cascade = CascadeType.PERSIST)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return jobName+" salary: "+salary;
    }
}
