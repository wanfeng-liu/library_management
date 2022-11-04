package cn.library.service;

import cn.library.dto.SysDto;
import cn.library.entity.Book;
import cn.library.utils.BookSysUtil;
import cn.library.utils.PageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Admin Page
public class AdminService {
    public void adminFunction(SysDto sysDto) {
        PageUtil.admin();
        List<String> adminValueList = Arrays.asList("0", "1", "2", "3", "4");
        String adminType = BookSysUtil.inputValue(adminValueList);
        
        switch (adminType) {
            case "1":
                // View books
                viewBooks(sysDto);
                break;
            case "2":
                // Add books
                addBooks(sysDto);
                break;
            case "3":
                //Modify books
                modifyBooks(sysDto);
                break;
            case "4":
                //Delete books
                deleteBooks(sysDto);
                break;
            case "0":
                //Return
                sysDto.getBookSysMain().home(sysDto);
                break;
            default:
                break;
        }
        adminFunction(sysDto);
    }

    private void deleteBooks(SysDto sysDto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter in the name or enter in 'exit' to return");
        System.out.print("Please enter in:");
        String bookName = scanner.nextLine();
        if(bookName.equals("exit")) {
            adminFunction(sysDto);
        }
        Book book = BookSysUtil.getBook(bookName, sysDto.getBookSysMain().bookDB);
        if(book != null) {
            sysDto.getBookSysMain().bookDB.remove(book);
            System.out.println("Delete Successfully!");
        }else{
            System.out.println("Such book does not exist!");
            System.out.println("Please check again");
            deleteBooks(sysDto);
        }
    }

    private void modifyBooks(SysDto sysDto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter in the book's name or 'exit' to return.");
        System.out.print("Please enter in the book's name:");
        String bookName = scanner.nextLine();
        if(bookName.equals("exit")) {
            adminFunction(sysDto);
        }
        for (Book book : sysDto.getBookSysMain().bookDB) {
            if(bookName.equals(book.getName())) {
                PageUtil.Modify();
                List<String> modifyValueList = Arrays.asList("0", "1", "2", "3", "4");
                String  modifyType = BookSysUtil.inputValue(modifyValueList);
                switch (modifyType) {
                    case "1":
                        System.out.print("Please enter in updated name:");
                        book.setName(scanner.nextLine());
                        System.out.println("Update Successfully!");
                        break;
                    case "2":
                        System.out.print("Please enter in updated author:");
                        book.setAuthor(scanner.nextLine());
                        System.out.println("Update Successfully!");
                        break;
                    case "3":
                        System.out.print("Please enter in update price:");
                        book.setPrice(scanner.nextDouble());
                        System.out.println("Update Successfully!");
                        break;
                    case "4":
                        System.out.print("Please enter in update stock:");
                        book.setStock(scanner.nextDouble());
                        System.out.println("Update Successfully!");
                        break;
                    case  "0":
                        PageUtil.Modify();
                        break;
                    default:
                        break;
                }

            }else{
                System.out.println("Such book does not exist. Please check");
                modifyBooks(sysDto);
                break;
            }
        }

    }

    private void addBooks(SysDto sysDto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter in the name of the book:");
        String name = scanner.nextLine();
        System.out.print("Please enter in the author of the book:");
        String author = scanner.nextLine();
        System.out.print("Please enter in the price of the book:");
        Double price = scanner.nextDouble();
        System.out.print("Please enter in the stock of the book:");
        Double stock = scanner.nextDouble();
        Book _book = new Book();
        _book.setName(name);
        _book.setAuthor(author);
        _book.setPrice(price);
        _book.setStock(stock);
        sysDto.getBookSysMain().bookDB.add(_book);
        System.out.println("Add"+_book.getName()+" Successfully!");
    }

    private void viewBooks(SysDto sysDto) {
        System.out.println("*************************************Library*************************************");
        System.out.println("Name              Author              Stock                  Price");
        for (Book book : sysDto.getBookSysMain().bookDB) {
            System.out.println(book.getName()+"     "+book.getAuthor()+"        "+book.getPrice()+"     "+book.getStock());
        }
        System.out.println("*********************************************************************************");
    }
}
