package application;

import entitie.enuns.WorkerLevel;
import entities.Department;
import entities.HourContract;
import entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException, ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workName = sc.nextLine();
        System.out.println("Level: ");
        String workLevel = sc.nextLine();
        System.out.println("Base salary: ");
        double baseSalary = sc.nextDouble();
        //Instanciando o trabalhador do tipo "Worker" e atribuindo pelo construtor
        //o WorkLevel usou o "Valueof" para conveter a String da variavel worklevel para o tipo enum
        Worker worker = new Worker(workName, WorkerLevel.valueOf(workLevel),baseSalary,new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract #"+ i +" Date: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hour = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour,hour);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: "+worker.getName());
        System.out.println("Department: "+ worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear + ": "+ String.format("%.2f", worker.income(year,month)));

        sc.close();
    }
}
