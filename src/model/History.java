package model;

import constants.SalaryStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {

    private SalaryStatus status;
    private LocalDateTime date;
    private int salary;

    //contructor co tham so
    public History(SalaryStatus status, LocalDateTime date, int salary) {
        this.status = status;
        this.date = date;
        this.salary = salary;
    }

    //GETTER
    public SalaryStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%10d %10s %10s", getSalary(), getStatus(),
                getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
