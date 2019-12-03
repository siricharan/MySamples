package com.test.slider.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person{
	private String firstName;
	private String lastName;
	private String gender;
	private Integer number;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public Person() {
	}

	public Person(String firstName, String lastName, String gender,int number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.number = number;
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGender() {
		return gender;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getNumber() {
		return number;
	}
	
	public void setFirstName(String firstName) {
		propertyChangeSupport.firePropertyChange("firstName", this.firstName,
				this.firstName = firstName);
	}

	public void setGender(String gender) {
		propertyChangeSupport.firePropertyChange("gender", this.gender,
				this.gender = gender);
	}

	public void setLastName(String lastName) {
		propertyChangeSupport.firePropertyChange("lastName", this.lastName,
				this.lastName = lastName);
	}
	public void setNumber(Integer number) {
		propertyChangeSupport.firePropertyChange("age", this.number,
				this.number = number);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}


}