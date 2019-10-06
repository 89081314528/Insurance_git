package com.company;

public class Main {

    public static void main(String[] args) {
    String human = "кочегарова;наталья;ивановна";
    String[] fi = human.split(";");
        for (int i = 0; i < fi.length; i++){
        System.out.println(fi[i]);
        }
        String[] csv = new String[]{
                "блинов;евгений;васильевич;м",
                "овчинников;евгений;анатольевич;м",
                "новичкова;ирина;витальевна;м",
                "леушина;оксана;вячеславовна;м"
        };
        //        преобразуем массив строк в массив сотрудников
        Employee[] employees = new Employee[4];
        for (int i = 0; i < 4; i++) {
            String line = csv[i];
            String[] fio = line.split(";");
            employees[i] = new Employee(fio[1], fio[0], fio[2], fio[3]);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(employees[i].getPatronymic());
        }
        for (int i = 0; i < 4; i++) {
            Employee oldEmployee = employees[i];
//            if (oldEmployee.getPatronymic().substring(oldEmployee.getPatronymic().length() - 3).equals("вна")) {
            // то же другим способом с оператором endWith
            if (oldEmployee.getPatronymic().endsWith("вна")) {
                // изменить значение полей без использования сетеров
//                Employee newEmployee = new Employee(
//                        oldEmployee.getName(),
//                        oldEmployee.getSurname(),
//                        oldEmployee.getPatronymic(),
//                        "ж");
//                employees[i] = newEmployee;
                // изменить значение полей с использованием сетеров
//                oldEmployee.setDetermineSex("ж");
                employees[i] = oldEmployee.withDetermineSex("ж");
            }
                System.out.println(employees[i].getSex());
        }
    }
}