package cn.library.utils;

public class PageUtil {
    public static void home() {
        System.out.println("**************Welcome to Library Management System**********");
        System.out.println("1. Reader");
        System.out.println("2. Manager");
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

    public static void readerQuery() {
        System.out.println("************************Query**************************");
    }
}
