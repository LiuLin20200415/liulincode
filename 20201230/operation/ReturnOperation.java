package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍！");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要归还的书名：");
        String name=scanner.nextLine();
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book= bookList.getBook(i);
            if(book.getName().equals(name)){
                //说明有这本书！
                //把这本书的借阅状态修改为false
                book.setStatus(false);
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有你要归还的图书！");
    }
}
