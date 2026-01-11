package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.DaoFactory;
import dao.EmployeeDao;
import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = DaoFactory.createEmployeeDao();

		
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);



		System.out.println("Enter the number of employees:");
		int n = sc.nextInt();
		sc.nextLine();


		for(int i = 1; i<=n; i++) {
			
			System.out.println("Employee "+"#"+i+" data:");
			System.out.print("Outsorced? (y/n):");
			String outsourced = sc.nextLine();
			
			System.out.print("Name:");
			String name = sc.nextLine();
			
			System.out.print("Hours:");
			Integer Hours = sc.nextInt();
			
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			
			Employee emp;
			
			if(outsourced.equalsIgnoreCase("y")) {
				System.out.println("Additional charge:");
				double additionalCharge = sc.nextDouble();
				emp = new OutsourcedEmployee(name, Hours, valuePerHour,additionalCharge);
				
			}else {
				emp = new Employee(name, Hours, valuePerHour);
			}
			
			sc.nextLine();
		
			employeeDao.insert(emp);

		}
		
		System.out.println("Employees:");
		List<Employee> list = employeeDao.findAll();
		
		for(Employee e : list) {
			System.out.println(e);
		}
		

		sc.close();

	}
}