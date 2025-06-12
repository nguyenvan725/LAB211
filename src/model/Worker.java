package model;

import constants.SalaryStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Worker {

    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;
    private ArrayList<History> salaryHistory;

    //contructor co tham so
    public Worker(String id, String name, int age, int salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.salaryHistory = new ArrayList<>();
        this.salaryHistory.add(new History(SalaryStatus.NOTCHANGE, LocalDateTime.now(), salary));

    }

    //getter, setter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public ArrayList<History> getSalaryHistory() {
        return salaryHistory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    //ham them ban ghi lich su luong
    public void addSalaryHistory(History history) {
        salaryHistory.add(history);
    }

    public String toString(History history) {
        return String.format("%s %-10s %-5d %-30s\n", id, name, age, history.toString());
    }
}
