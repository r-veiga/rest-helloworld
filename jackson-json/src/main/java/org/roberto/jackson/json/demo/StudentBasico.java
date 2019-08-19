package org.roberto.jackson.json.demo;

public class StudentBasico {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
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
	@Override
	public String toString() {
		return "StudentBasico [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ "]";
	}
	
	
}
