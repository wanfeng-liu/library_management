package cn.library.service;

import cn.library.dto.SysDto;
import cn.library.entity.Book;
import cn.library.utils.BookSysUtil;
import cn.library.utils.PageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Reader Page
public class ReaderService {
    public void readerFunction(SysDto sysDto) {
        PageUtil.reader();
        List<String> readerValueList = Arrays.asList("0", "1", "2", "3", "4");
        String readerType = BookSysUtil.inputValue(readerValueList);
            switch (readerType) {
                case "1":
                    //View Books
                    viewBooks(sysDto);
                    break;
                case "2":
                    //Borrow Books
                    borrowBooks(sysDto);
                    break;
                case "3":
                    //Return Books
                    remandBooks(sysDto);
                    break;
                case "4":
                    //Check Borrowed Books
                    viewBorrowBookList(sysDto);
                    break;
                case "0":
                    //Return
                    sysDto.getBookSysMain().home(sysDto);
                    break;
                default:
                    break;
            }
        readerFunction(sysDto);
    }

    private void remandBooks(SysDto sysDto) {
        /**
         * 1. enter the name of book which you want to return
         * 2. the stock of such book in borrowBookDB is subtracted one
         * 3. the stock of such book in bookDB is added one
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of book which you want to return or enter 'exit' to return.");
        System.out.print("Please enter in:");
        String returnName = scanner.nextLine();
        Boolean existBorrow = false; // whether exists in borrowBookDB
        Boolean existLibrary = false;//whether exists in library
        String author = null;
        Double price = 0.0;
        if(returnName.equals("exit")) {
            readerFunction(sysDto);
        }
        for (Book book : sysDto.getBookSysMain().borrowBookDB) {
            if(returnName.equals(book.getName())) {
                author = book.getAuthor();
                price = book.getPrice();
                if(book.getStock() == 1) {
                    sysDto.getBookSysMain().borrowBookDB.remove(book);
                    existBorrow = true;
                    break;
                }else{
                    book.setStock(book.getStock()-1);
                    existBorrow = true;
                    break;
                }
            }else{
                System.out.println("Such book does not exist!");
                System.out.println("Please enter the name of book again!");
                remandBooks(sysDto);
            }
        }

        if(existBorrow) {
            for (Book book : sysDto.getBookSysMain().bookDB) {
                if(book.getName().equals(returnName)) {
                    book.setStock(book.getStock()+1);
                    existLibrary = true;
                    break;
                }
            }
            if(!existLibrary) {
                Book _book = new Book();
                _book.setName(returnName);
                _book.setAuthor(author);
                _book.setPrice(price);
                _book.setStock(1.0);
                sysDto.getBookSysMain().bookDB.add(_book);
            }
            System.out.println("Return the book successfully!");
        }
    }

    private void viewBorrowBookList(SysDto sysDto) {
        System.out.println("*******************Borrowed Books List:*************************");
        System.out.println("Name        Author       Stock          Price");
        sysDto.getBookSysMain().borrowBookDB.forEach(book -> {
            System.out.println(book.getName()+"     "+book.getAuthor()+"        "+book.getStock()+"         "+book.getPrice());
        });
    }

    private void borrowBooks(SysDto sysDto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter in the name of books you want to borrow or enter 'exit' to return.");
        System.out.print("Please enter in:");
        String bookName = scanner.nextLine();
        Boolean exist = false;
        if(bookName.equals("exit")) {
            readerFunction(sysDto);
        }
        for (Book book : sysDto.getBookSysMain().bookDB) {
            if(bookName.equals(book.getName()) && book.getStock() > 1) {
                for (Book book1 : sysDto.getBookSysMain().borrowBookDB) {
                    if(book1.getName().equals(bookName)) {
                        book1.setStock(book1.getStock()+1);
                        exist = true;
                        break;
                    }
                }
                if(!exist) {
                    Book _book = new Book();
                    _book.setStock(1.0);
                    _book.setAuthor(book.getAuthor());
                    _book.setName(book.getName());
                    _book.setPrice(book.getPrice());
                    sysDto.getBookSysMain().borrowBookDB.add(_book);
                }
                book.setStock(book.getStock()-1);
                exist = false;
                System.out.println("Borrow Successfully!");
                break;
            } else if (bookName.equals(book.getName()) && book.getStock() == 1) {
                for (Book book1 : sysDto.getBookSysMain().borrowBookDB) {
                    if(book1.getName().equals(bookName)) {
                        book1.setStock(book1.getStock()+1);
                        exist = true;
                        break;
                    }
                }
                if(!exist) {
                    Book _book = new Book();
                    _book.setStock(1.0);
                    _book.setAuthor(book.getAuthor());
                    _book.setName(book.getName());
                    _book.setPrice(book.getPrice());
                    sysDto.getBookSysMain().borrowBookDB.add(_book);
                }
                sysDto.getBookSysMain().bookDB.remove(book);
                exist = false;
                System.out.println("Borrow Successfully!");
                break;
            }else{
                System.out.println("Such book does not exit!");
                System.out.println("Please enter in again!");
                borrowBooks(sysDto);
                break;
            }
        }
    }

    private void viewBooks(SysDto sysDto) {
        System.out.println("***************************************************");
        //JDK 1.5
//        for (Book book : sysDto.getBookSysMain().bookDB) {
//
//        }
        //JDK 1.8
        if(sysDto.getBookSysMain().bookDB.size() != 0) {
            System.out.println("Name        Author       Stock          Price");
            sysDto.getBookSysMain().bookDB.forEach(book -> {
                System.out.println(book.getName()+"     "+book.getAuthor()+"        "+book.getStock()+"         "+book.getPrice());
            });
        }else{
            System.out.println("There is no book in system!");
            System.out.println("Please add books!");
        }

        System.out.println("***************************************************");

    }
}
