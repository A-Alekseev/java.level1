package ru.gb.alekseev.homework5;

public class Main {
    public static void main(String[] args) {
        Employer[] employers = {
                new Employer("Alekseev Aleksey", "Team leader", "a.alx@bk.ru", "892312312", 300000, 50),
                new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30),
                new Employer("Petrov Sidor", "Project manager", "petrov@mailbox.com", "892312313", 25000, 55),
                new Employer("Ermolaev Mazai", "Web designer", "ermolaev@mailbox.com", "892312314", 10000, 18),
                new Employer("Tigranov Levon", "Director", "tigranov@mailbox.com", "892312315", 60000, 41),
        };

        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employer employer : employers) {
            if (employer.getAge() > 40){
                employer.print();
                System.out.println();
            }
        }
    }
}
