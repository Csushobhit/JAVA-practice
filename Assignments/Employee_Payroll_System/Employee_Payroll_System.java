import java.util.InputMismatchException;
import java.util.Scanner;
  
public class Employee_Payroll_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee emp = null;

        while (true) {
            try {

                System.out.println("\n--- EMPLOYEE PAYROLL MENU ---");
                System.out.println("1. Create Employee");
                System.out.println("2. See Details");
                System.out.println("3. Change Salary");
                System.out.println("4. Get Salary");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee Type (1-FullTime, 2-Contractual): ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Role (HR / Others): ");
                        String r = sc.nextLine();
                        Role role = Role.valueOf(r);

                        System.out.print("Enter Salary: ");
                        double sal = sc.nextDouble();

                        if (type == 1) {
                            emp = new FulltimeEmployee(id, name, role, sal);
                        } else if (type == 2) {
                            emp = new ContractualEmployee(id, name, role, sal);
                        } else {
                            System.out.println("Invalid employee type");
                            break;
                        }

                        System.out.println("Employee created successfully");
                        break;

                    case 2:
                        if (emp == null) {
                            System.out.println("Create employee first");
                            break;
                        }

                        System.out.print("Enter ID to view details: ");
                        String vid = sc.nextLine();

                        System.out.print("Enter your role (HR / Others): ");
                        String vr = sc.nextLine();
                        Role vrole = Role.valueOf(vr);

                        emp.seeDetails(vid, vrole);
                        break;

                    case 3:
                        if (emp == null) {
                            System.out.println("Create employee first");
                            break;
                        }

                        System.out.print("Enter your role (HR / Others): ");
                        String cr = sc.nextLine();
                        Role crole = Role.valueOf(cr);

                        System.out.print("Enter new salary: ");
                        double ns = sc.nextDouble();

                        emp.changeSalary(crole, ns);
                        System.out.println("Salary updated successfully");
                        break;

                    case 4:
                        if (emp == null) {
                            System.out.println("Create employee first");
                            break;
                        }

                        double pay = emp.calculatepay();
                        System.out.println("Payable Salary: " + pay);
                        break;

                    case 5:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InvalidSalaryException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (UnauthorizedAccessException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role");
            }
        }
    }
}


enum Role
{
	HR,
	Others;
}

interface Payrole
{
	double calculatepay();
}

class UnauthorizedAccessException extends RuntimeException
{
	UnauthorizedAccessException(String message)
	{
		super(message);
	}
}

class InvalidSalaryException extends Exception
{
	InvalidSalaryException(String message)
	{
		super(message);
	}
}

abstract class Employee implements Payrole
{
	private String ID;
	private String name;
	private Role role;
	protected double salary;
	
	public Employee(String ID, String name, Role role, double salary) throws InvalidSalaryException
	{
		if(salary <0)
		{
			throw new InvalidSalaryException("Salary Can't be zero");
		}
		this.ID = ID;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	protected void seeDetails(String ID, Role role) throws UnauthorizedAccessException
	{
		if(this.ID == ID)
		{
			System.out.println(this.ID + this.name + this.role + this.salary);
		}
		else if(role == Role.HR)
		{
			System.out.println(this.ID + this.name + this.role + this.salary);
		}
		else
		{
			throw new UnauthorizedAccessException("Unauthorized Access");
		}
	}
	protected void changeSalary(Role role, double Salary) throws UnauthorizedAccessException, InvalidSalaryException
	{
		if(role == Role.HR)
		{
			if(Salary > 0)
			{
			this.salary = Salary;
			}
			else
			{
				throw new InvalidSalaryException("Salary can't be negative");
			}
		}
		else
		{
			throw new UnauthorizedAccessException("Unauthorized Access");
		}
	}
	public double calculatepay()
	{
		return this.salary;
	}
}
class FulltimeEmployee extends Employee
{
	public FulltimeEmployee(String ID, String name, Role role, double salary) throws InvalidSalaryException
	{
		super(ID, name, role, salary);
	}
	public double calculatepay()
	{
		System.out.println("You are full time");
		return this.salary;
	}
}
class ContractualEmployee extends Employee
{
	public ContractualEmployee(String ID, String name, Role role, double salary) throws InvalidSalaryException
	{
		super(ID, name, role, salary);
	}
	public double calculatepay()
	{
		System.out.println("You are full time");
		return this.salary;
	}
}
