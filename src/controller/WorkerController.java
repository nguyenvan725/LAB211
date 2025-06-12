package controller;

import exception.SystemException;
import java.util.ArrayList;
import model.History;
import model.Worker;
import service.SalaryService;
import view.WorkerView;
import dto.WorkerDTO;

import constants.SalaryStatus;

public class WorkerController {

    private WorkerDTO inputData;
    private ArrayList<Worker> listWorker = new ArrayList<>();
    private SalaryService salaryService = new SalaryService();
    private WorkerView workerView = new WorkerView();

    //setter
    public void setInputData(WorkerDTO inputData) {
        this.inputData = inputData;
    }

    //ham them worker
    public void addWorker() throws SystemException {
        //kiem tra id trung lap
        checkIdDuplicate();
        //add
        listWorker.add(new Worker(inputData.getId(), inputData.getName(), inputData.getAge(),
                inputData.getSalary(), inputData.getWorkLocation()));
    }

    //ham tang luong
    public void increaseSalary(String id, int amount) throws SystemException {
        salaryService.setListWorker(listWorker);
        salaryService.upSalary(id, amount);
    }

    //ham giam luong
    public void deCreaseSalary(String id, int amount) throws SystemException {
        salaryService.setListWorker(listWorker);
        salaryService.downSalary(id, amount);
    }

    //ham hien thi lich su luong
    public void displayInformation() throws SystemException {

        boolean hasChanges = false;//co kiem tra co thay doi luong ko

        StringBuilder body = new StringBuilder();
        for (Worker worker : listWorker) {
            ArrayList<History> workerHistory = worker.getSalaryHistory();
            if (workerHistory != null && !workerHistory.isEmpty()) {
                for (History curr : workerHistory) {
                    if (curr.getStatus() == SalaryStatus.DOWN || curr.getStatus() == SalaryStatus.UP) {
                        body.append(worker.toString(curr));
                        hasChanges = true;
                    }
                }
            }
        }
        if (!hasChanges) {
            throw new SystemException("List is empty");
        }
        workerView.setHeader(String.format("%-5s %5s %-10s %-10s %-10s %-15s", "Code", "Name", "Age", "Salary", "Status", "Date"));
        workerView.setBody(body.toString());
        workerView.displayHistory();
    }

    //ham kiem tra trung lap
    private void checkIdDuplicate() throws SystemException {
        for (Worker w : listWorker) {
            if (w.getId().equalsIgnoreCase(inputData.getId())) {
                throw new SystemException("ID has been existed. Try again");
            }
        }
    }
}
