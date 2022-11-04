package cn.library;

import cn.library.dto.SysDto;
import cn.library.entity.Book;
import cn.library.service.AdminService;
import cn.library.service.ReaderService;
import cn.library.utils.BookSysUtil;
import cn.library.utils.PageUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BookSysMain {
    ReaderService readerService = new ReaderService();
    AdminService adminService = new AdminService();

    //database of the library
    public List<Book> bookDB = new ArrayList<>();
    {
        Book book = new Book();
        book.setName("Moon");
        book.setAuthor("William Somerset Maugham");
        book.setPrice(30.6);
        book.setStock(2.0);
        bookDB.add(book);
    }

    //database of borrowed books
    public List<Book> borrowBookDB = new ArrayList<>();

    public static void main(String[] args) {
        SysDto sysDto = new SysDto();
        sysDto.setBookSysMain(new BookSysMain());
        sysDto.getBookSysMain().home(sysDto);
    }
    public void home(SysDto sysDto) {
        PageUtil.home();
        String typeValue = BookSysUtil.inputValue(Arrays.asList("0", "1", "2"));
        switch (typeValue) {
            case "1":
                //Reader
                readerService.readerFunction(sysDto);
                break;
            case "2":
                //Admin
                adminService.adminFunction(sysDto);
                break;
            case "0":
                //Exit
                bookSysExit();
                break;
        }
    }


    //Exit system
    private static void bookSysExit() {
        System.exit(0);
    }
}
