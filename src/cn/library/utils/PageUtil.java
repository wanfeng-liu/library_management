package cn.library.utils;

public class PageUtil {
    public static void home() {
        System.out.println("**************Welcome to Library Management System**********");
        System.out.println("1. Reader");
        System.out.println("2. Admin");
        System.out.println("0. Exit");
        System.out.print("Please Select your Roles:");
    }

    public static void reader() {
        System.out.println("************************Reader************************");
        System.out.println("1. View Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Check Borrowed Books");
        System.out.println("0. Return");
        System.out.print("Please Enter in:");
    }

    public static void admin() {
        System.out.println("************************Admin************************");
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Modify Books");
        System.out.println("4. Delete Books");
        System.out.println("0. Return");
        System.out.print("Please Enter in:");
    }

    public static void Modify() {
        System.out.println("***********************Modify***************************");
        System.out.println("1. Modify name");
        System.out.println("2. Modify author");
        System.out.println("3. Modify price");
        System.out.println("4. Modify stock ");
        System.out.println("0. Return");
        System.out.print("Please enter in:");
    }
}
