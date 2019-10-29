package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // создаем файл emloyes.csv в корневой директории проекта - Insurance sex (пкм new file)
        List<String> csv = Files.lines(new File("employes.csv").toPath())
                .collect(Collectors.toList());

        //        преобразуем массив строк в массив сотрудников
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < csv.size(); i++) {
            String line = csv.get(i);
            String[] fio = line.split(";");
            employees.add(new Employee(fio[1], fio[0], fio[2], fio[3]));
        }
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getPatronymic());
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee oldEmployee = employees.get(i);
            if (oldEmployee.getPatronymic().endsWith("вна")) {
                employees.set(i, oldEmployee.withDetermineSex("ж"));
            } else
            if (oldEmployee.getPatronymic().endsWith("вич")) {
                employees.set(i, oldEmployee.withDetermineSex("м"));
            }
            else {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите пол " + oldEmployee.getName() + " " + oldEmployee.getSurname() +
                        " " + oldEmployee.getPatronymic());
                employees.set(i, oldEmployee.withDetermineSex(scanner.next()));
            }
            System.out.println(employees.get(i).getSex());
        }
    }
}

