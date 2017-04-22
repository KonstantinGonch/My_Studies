package com.none;

import javax.persistence.*;

@Entity
@Table(name="person")
@Access(AccessType.FIELD)
@NamedQueries({@NamedQuery(name = "Person.findAll", query = "SELECT p FROM com.none.Person p")})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "j_id")
    private Job job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        job.setPerson(this);
    }

    @Override
    public String toString()
    {
        return name+" "+surname+" Job: "+job;
    }
}
