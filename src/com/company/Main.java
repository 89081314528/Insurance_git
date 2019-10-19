package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        List<String> lines = Files.lines(new File("employes.csv").toPath())
                .collect(Collectors.toList());
        String[] csv = lines.toArray(new String[0]);

        //        преобразуем массив строк в массив сотрудников
        Employee[] employees = new Employee[csv.length];
        for (int i = 0; i < csv.length; i++) {
            String line = csv[i];
            String[] fio = line.split(";");
            employees[i] = new Employee(fio[1], fio[0], fio[2], fio[3]);
        }
        for (int i = 0; i < csv.length; i++) {
            System.out.println(employees[i].getPatronymic());
        }
        for (int i = 0; i < csv.length; i++) {
            Employee oldEmployee = employees[i];
            if (oldEmployee.getPatronymic().endsWith("вна")) {
                employees[i] = oldEmployee.withDetermineSex("ж");
            }
                System.out.println(employees[i].getSex());
        }
    }
}