package com.company.customerinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@ApiModel(value = "Customer", description = "The model for customer")
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(notes = "Name of the customer",name="name",required=true,value="test name")
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(notes = "Age of the customer",name="age",required=true,value="1")
    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="CUSTOMER_ADDRESS", joinColumns={@JoinColumn(name="CUSTOMER_ID", referencedColumnName="ID")}
            , inverseJoinColumns={@JoinColumn(name="ADDRESS_ID", referencedColumnName="ID")})
    private Set<Address> addresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
