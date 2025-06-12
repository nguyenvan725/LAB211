package view;

public class WorkerView {

    private String header;
    private String body = ""; // Khởi tạo body với chuỗi rỗng
    private String message;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //
    public void displayHistory() {
        System.out.println(header);
        System.out.println(body);
    }

    public void displayMessage() {
        System.out.println(message);
    }

    public void displayWarning() {
        System.err.println(message);
    }

}
