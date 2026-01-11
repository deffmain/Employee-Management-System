package entities;

public class Employee {
	
	protected Integer id;
	protected String name;
	protected Integer hours;
	protected double valuePerHour;
	
	public Employee() {}

	public Employee(String name, Integer hours, double valuePerHour) {
		super();
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double getValuePerHouer() {
		return valuePerHour;
	}

	public void setValuePerHouer(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double payment() {
		return hours * valuePerHour;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" - ").append(String.format("%.2f",payment()));		
		return sb.toString();
	}
	

}
