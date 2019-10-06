package com.company;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        String accountant = "новичкова;ирина;витальевна;ж";
        String[] fio = accountant.split(";");
        for (int i = 0; i < fio.length; i++) {
//            System.out.println(fio[i]);
        }
        String[] employeesCsv = new String[] {
                "забиров;тимур;фаильевич; ",
                "иванов;павел;оглы; ",
                "сорокин;игорь;михайлович; ",
                "степанов;сергей;владимиров; ",
                "новичкова;ирина;витальевна; ",
                "леушина;оксана;вячеславовна; "
        };
        Employee[] employees = new Employee[employeesCsv.length];
        for (int i = 0; i < employees.length; i++) {
            String line = employeesCsv[i];
            String[] fioSex = line.split(";");
            employees[i] = new Employee(fioSex[0], fioSex[1], fioSex[2], fioSex[3]);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getPatronymic().substring(employees[i].getPatronymic().length() - 3).equals("вна")) {
                Employee oldEmployee = employees[i];
                oldEmployee.withDetermineSex("ж");
            } else
            if (employees[i].getPatronymic().substring(employees[i].getPatronymic().length() - 3).equals("вич")) {
                Employee oldEmployee = employees[i];
                oldEmployee.withDetermineSex("м");
            } else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите пол " + employees[i].getName() + " " + employees[i].getSurname() + " " + employees[i].getPatronymic());
                Employee oldEmployee = employees[i];
                oldEmployee.withDetermineSex(scanner.next());
            }
            System.out.println(employees[i].getPatronymic());
            System.out.println(employees[i].getSex());
        }
    }
}


