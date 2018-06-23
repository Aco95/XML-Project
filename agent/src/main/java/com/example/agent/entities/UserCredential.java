package com.example.agent.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserCredential", propOrder = {
	"id",
    "email",
    "password"

})
@Document(collection="UsersCredential")
public class UserCredential {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String password;
    
}
