package com.abc.simplewebapp.controllers;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;

import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterForm {

	@JsonProperty("first_name") // for serialization and deserialization
	@JsonAlias("fname") // additional names
	// you can also use Gson: @SerializedName(value="location", alternate="place")
	String firstName;
	@JsonProperty("last_name")
    String lastName;
    Date dateGraduated;
    Integer score;
    String city;
    Character desiredCollege;
    String comments;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateGraduated() {
		return dateGraduated;
	}
	public void setDateGraduated(Date dateGraduated) {
		this.dateGraduated = dateGraduated;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Character getDesiredCollege() {
		return desiredCollege;
	}
	public void setDesiredCollege(Character desiredCollege) {
		this.desiredCollege = desiredCollege;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
