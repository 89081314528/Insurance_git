package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
    String human = "кочегарова;наталья;ивановна";
    String[] fi = human.split(";");
        for (int i = 0; i < fi.length; i++){
        System.out.println(fi[i]);
        }
//        String[] csv = new String[]{
//                "блинов;евгений;васильевич;м",
//                "овчинников;евгений;анатольевич;м",
//                "новичкова;ирина;витальевна;м",
//                "леушина;оксана;вячеславовна;м"
//        };
        // создаем файл emloyes.csv в корневой директории проекта - Insurance sex (пкм new file)
        List<String> lines = Files.lines(new File("employes.csv").toPath())
                .collect(Collectors.toList());
//        String[] csv = lines.toArray(new String[0]);
        List<String> csv = lines;

        //        преобразуем массив строк в массив сотрудников
//        Employee[] employees = new Employee[csv.length];
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < csv.size(); i++) {
            String line = csv.get(i);
            String[] fio = line.split(";");
            employees.add(new Employee(fio[1], fio[0], fio[2], fio[3]));
        }
        for (int i = 0; i < csv.size(); i++) {
            System.out.println(employees.get(i).getPatronymic());
        }
        for (int i = 0; i < csv.size(); i++) {
            Employee oldEmployee = employees.get(i);
            if (oldEmployee.getPatronymic().endsWith("вна")) {
                employees.set(i, oldEmployee.withDetermineSex("ж"));
            }
                System.out.println(employees.get(i).getSex());
        }
    }
}