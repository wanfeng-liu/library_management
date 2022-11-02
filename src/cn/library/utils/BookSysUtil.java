package cn.library.utils;

import java.util.List;
import java.util.Scanner;

public class BookSysUtil {
    public static String inputValue(List<String> userTypeValueList) {
        Scanner scanner = new Scanner(System.in);
        String typeValue = scanner.nextLine();
        while(true) {
            if(!userTypeValueList.contains(typeValue)) {
                System.out.println("Enter failed, please enter again.");
                typeValue = scanner.nextLine();
            }else{
                break;
            }
        }
       return typeValue;
    }
}
