package registrationScheduler.util;

public class Course {
	private int seats;
	private String name;

	/*
	 * Constructor init the private variables
	 * 
	 */
	public Course() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * 
	 * @param newName
	 */
	public Course(String newName) {
		this.setName(newName);
		setSeats(60);
	}

	public int getSeats() {
		return seats;
	}

	/**
	 * 
	 * @param seatsIN
	 */
	public void setSeats(int seatsIN) {
		this.seats = seatsIN;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [seats=" + seats + ", name=" + name + ", getSeats()=" + getSeats() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
