import cn.library.utils.BookSysUtil;
import cn.library.utils.PageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookSysMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PageUtil.home();
        //Make sure the entered value is valid
        //String[] typeList = {"1", "2", "0"};
        List<String> userTypeValueList = Arrays.asList("1", "2", "0");
        String typeValue = BookSysUtil.inputValue(userTypeValueList);

        if("1".equals(typeValue) ) {
            PageUtil.reader();//Reader Page
            List<String> readerTypeValueList = Arrays.asList("0", "1", "2", "3", "4");//the options of readers
            String readerTypeValue = BookSysUtil.inputValue(readerTypeValueList);

            
            if("1".equals(readerTypeValue)) {
                PageUtil.readerQuery();
            }


        }else if("2".equals(typeValue) ) {
            System.out.println(typeValue);
        }else if("0".equals(typeValue)) {
            //Exit system
            bookSysExit();
        }
    }
    private static void bookSysExit() {
        System.exit(0);
    }
}
