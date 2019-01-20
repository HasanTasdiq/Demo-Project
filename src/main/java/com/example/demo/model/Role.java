package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role",schema="test3")
public class Role {
    @Id
    @Column(name="role_id")
    private int role_id;
    @Column(name="role_type")
    private String role_type;

    public Role(int role_id, String role_type) {
        this.role_id = role_id;
        this.role_type = role_type;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_type='" + role_type + '\'' +
                '}';
    }
}
