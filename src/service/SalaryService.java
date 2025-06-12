package service;

import constants.SalaryStatus;
import exception.SystemException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.History;
import model.Worker;

public class SalaryService {

    private List<Worker> listWorker = new ArrayList<>();

    //getter, setter
    public List<Worker> getListWorker() {
        return listWorker;
    }

    public void setListWorker(List<Worker> listWorker) {
        this.listWorker = listWorker;
    }

    // Phương thức mới để tăng lương và cập nhật worker
    public void upSalary(String id, int amount) throws SystemException {
        for (Worker worker : listWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                worker.setSalary(amount + worker.getSalary());
                History history = new History(SalaryStatus.UP, LocalDateTime.now(), worker.getSalary());
                worker.addSalaryHistory(history);
                return;
            }
        }
        throw new SystemException("ID is not exist. Try again.");
    }

    public void downSalary(String id, int amount) throws SystemException {
        for (Worker worker : listWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                worker.setSalary(worker.getSalary() - amount);
                History history = new History(SalaryStatus.DOWN, LocalDateTime.now(), worker.getSalary());
                worker.addSalaryHistory(history);
                return;
            }
        }
        throw new SystemException("ID is not exist. Try again.");
    }

}
