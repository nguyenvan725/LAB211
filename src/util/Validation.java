package utils;

import java.util.Scanner;

/**
 * @author Custom Implementation
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    // Kiểm tra số nguyên trong phạm vi [min, max]
    public static int checkInputIntLimit(String s, int min, int max) {
        while (true) {
            System.out.print(s);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Input must be in range [" + min + ", " + max + "]");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value. Please enter a valid integer.");
            }
        }
    }

    // Kiểm tra chuỗi không rỗng
    public static String checkInputString(String s) {
        while (true) {
            System.out.print(s);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty.");
                continue;
            }
            return result;
        }
    }

    // Kiểm tra lương hoặc amount phải lớn hơn 0
    public static int checkInputPositiveAmount(String s) {
        while (true) {
            System.out.print(s);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    System.err.println("Input must be greater than 0.");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value. Please enter a valid integer.");
            }
        }
    }

    // Kiểm tra tuổi trong khoảng 18-50
    public static int checkInputAge(String s) {
        return checkInputIntLimit(s, 18, 50);
    }
}
