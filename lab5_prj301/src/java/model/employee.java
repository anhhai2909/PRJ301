/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class employee {
    private name name;
    private Address address;

    public employee() {
    }

    public employee(name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public name getName() {
        return name;
    }

    public void setName(name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
