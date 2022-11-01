import java.util.Scanner;

public class BookSysMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************Welcome to Library Management System**********");
        System.out.println("1. Reader");
        System.out.println("2. Manager");
        System.out.print("Please Select your roles:");
        String usertype = scanner.nextLine();
        System.out.println(usertype);
    }
}
