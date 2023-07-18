import java.util.Scanner;
import java.io.*;

public class YankowskiPayrollP2 {
   
  public static void main(String[] args) throws IOException {
    // Initialize variables
    double taxRate = .08;
    double netPay = 0;
    double taxesPaid = 0;
    double totalGPay = 0;
    double totNetPay = 0;
    double totTaxPaid = 0;
    int employeesCount = 0;
    String firstName = " ";
    String midInit =  " ";
    String lastName = " ";
    String iD = " ";
    String level = " ";
    String hours = " ";
    double pay = 0;
  
    // Open the file for reading
    File readFile = new File("employees.txt");
    Scanner inputFile = new Scanner(readFile);
    
    // Check if the file exists
    if (readFile.exists()) 
    {
      System.out.println("File exists");
    } 
    else 
    {
      System.out.println("File does not exist");
      inputFile.close();
    }
    
    // Read and display the company name from the file
    String line = inputFile.nextLine();
    System.out.println("Company Name: " + line);

    // Loop through each employee in the file
    while (inputFile.hasNext()) {
      // Read employee information from the file
      firstName = inputFile.nextLine();
      midInit = inputFile.nextLine();
      lastName = inputFile.nextLine();
      iD = inputFile.nextLine();
      level = inputFile.nextLine();
      hours = inputFile.nextLine();
      employeesCount++;
      
      // Extract relevant information from the read data
      char employeeLevel = level.charAt(0);
      double employHours = Double.parseDouble(hours);
      int idChar = Integer.parseInt(iD);
      char midInitial = midInit.charAt(0);
   
      // Calculate pay, taxes paid, and net pay based on employee level and hours worked
      if (employeeLevel == 'A') {
        pay = 12.00 * employHours;
      } else if (employeeLevel == 'B') {
        pay = 14.50 * employHours;
      } else if (employeeLevel == 'C') {
        pay = 16.00 * employHours;
      } else if (employeeLevel == 'D') {
        pay = 20.00 * employHours;
      }
      
      taxesPaid = pay * taxRate;
      netPay = pay - taxesPaid;
      
      // Print employee information with calculated pay, taxes, and net pay
      System.out.printf("Employee: %S %S %S  Email Address: %S.%S.%S@hvcc.com   ID Number: %d Gross Pay: $%.2f  Taxes: $%.2f  Net Pay: $%.2f\n", firstName, midInitial, lastName, firstName, midInitial, lastName,  idChar, pay, taxesPaid,netPay);
      
      // Update total gross pay, total net pay, and total taxes paid
      totalGPay += pay;
      totNetPay += netPay;
      totTaxPaid += taxesPaid;
    }
    
    // Print the number of employees and the totals for gross pay, taxes, and net pay
    System.out.println("Number of employees: " + employeesCount);
    System.out.printf("Totals     GrossPay: $%.2f   Taxes: $%.2f   Net Pay: $%.2f ", totalGPay, totTaxPaid, totNetPay);
    
    // Close the file
    inputFile.close();
  }
}
