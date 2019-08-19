package org.roberto.jackson.json.demo;

import java.util.List;

public class StudentComplejo {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private List<String> languages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	@Override
	public String toString() {
		return "StudentComplejo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active="
				+ active + ", address=" + address + ", languages=" + languages + "]";
	}
	
	
}
