
import constants.Message;
import controller.WorkerController;
import dto.WorkerDTO;
import utils.Validation;
import exception.SystemException;

public class Main {

    public static void main(String[] args) throws SystemException {
        WorkerController workerController = new WorkerController();
        WorkerDTO inputForm = new WorkerDTO();
        //in menu
        System.out.print(Message.MSG_MENU);

        while (true) {
            inputForm = new WorkerDTO();//reset cho moi lan lap
            int choice = Validation.checkInputIntLimit("Enter your choice: ", 1, 5);

            try {

                switch (choice) {
                    case 1: // Add Worker
                        System.out.println(Message.MSG_TITLE1);
                        inputForm.setId(Validation.checkInputString("Enter Code: "));
                        inputForm.setName(Validation.checkInputString("Enter Name: "));
                        inputForm.setAge(Validation.checkInputAge("Enter Age: "));
                        inputForm.setSalary(Validation.checkInputPositiveAmount("Enter Salary: "));
                        inputForm.setWorkLocation(Validation.checkInputString("Enter Work Location: "));
                        workerController.setInputData(inputForm);
                        workerController.addWorker();
                        System.out.println("Add successfull");
                        break;

                    case 2: // Increase Salary
                        System.out.println(Message.MSG_TITLE2);
                        inputForm.setId(Validation.checkInputString("Enter Code: "));
                        inputForm.setAmount(Validation.checkInputPositiveAmount("Enter amount to increase: "));
                        workerController.setInputData(inputForm);
                        workerController.increaseSalary(inputForm.getId(), inputForm.getAmount());
                        System.out.println("Successfull");
                        break;

                    case 3: // Decrease Salary
                        System.out.println(Message.MSG_TITLE3);
                        inputForm.setId(Validation.checkInputString("Enter Code: "));
                        inputForm.setAmount(Validation.checkInputPositiveAmount("Enter amount to decrease: "));
                        workerController.setInputData(inputForm);
                        workerController.deCreaseSalary(inputForm.getId(), inputForm.getAmount());
                        System.out.println("Successfull");
                        break;

                    case 4: // Display Information
                        System.out.println(Message.MSG_TITLE4);
                        workerController.displayInformation();
                        System.out.println("Successfull");
                        break;

                    case 5: // Quit
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
