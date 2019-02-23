import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.ems.dto.Author;
import com.cg.ems.dto.Book;
import com.cg.ems.service.BookAuthorService;
import com.cg.ems.service.BookAuthorServiceImpl;

public class JPAAuthorBookMain {

	static BookAuthorService authser=new BookAuthorServiceImpl();
	
	  public static void main(String[] args) 
			 {
		 System.out.println("Enter your choice"); 
		 System.out.println("1.) Enter the details of Author");
		 System.out.println("2.) Enter the details of book");
		 System.out.println("3.) View Details of all the Book");
		 System.out.println("4.) View Details of book by Author name");
		 System.out.println("5.) Fetch book by price");
		 System.out.println("6.) Fetch Author by book ISBN CODE");
		 System.out.println("7.) Exit");
		 
			Scanner scanner=new Scanner(System.in);
			
			 int authId=0;
			 String authName;
			 int ISBNCode;
			 String bookTitle;
			 int bookPrice;
			 while(true)
			 {
	 switch(scanner.nextInt())
	 {
	 case 1:
		 System.out.println("=====Enter Author Data=====");
	 System.out.println("Author Id generated Automatically \n");
	 System.out.println("Enter the Author Name \n");
	 authName=scanner.nextLine();	
	 authName+=scanner.nextLine();
	 Author auth=new Author();
	 auth.setAuthId(authId);
	 auth.setAuthName(authName);
	 Author auth1= authser.addAuthorDetails(auth);
	 System.out.println("=======Author data is entered======");
	 break;
	 
	 case 2:
		 System.out.println("=====Enter Book Data=====");
	 System.out.println("Book ISBN Code generated Automatically \n");
	 System.out.println("Enter the Book Title \n");
	 bookTitle=scanner.next();	
	 System.out.println("Enter Book Price");
	 bookPrice=scanner.nextInt();
	 Book book=new Book();
	 book.setBookTitle(bookTitle);
	 book.setBookPrice(bookPrice);
	 Book book1= authser.addBookDetails(book);
	 System.out.println("=======Book data is entered======");
	 break;
	 
	 case 3:
		 System.out.println("Fetch All Record");
		 ArrayList<Book> booklist=authser.fetchAllBook();
		 for(Book temp:booklist)
		 {
			 System.out.println(temp.getISBNCode()+"\t" +temp.getBookTitle()+"\t"+temp.getBookPrice());
		 }
		 break;
		
	 case 4:
		  System.out.println("Enter author name whom book you want to display");
		  scanner.next();
		  String authname = scanner.next();
		  Book auth2=authser.fetchbyAuthor(authname);
		  System.out.println(auth2);
		  break;
		  
	 case 5:
		 System.out.println("Enter Price Range");
		 int p1 = scanner.nextInt();
		 int p2 = scanner.nextInt();
		 Book fetchbook=authser.fetchByPriceRange(p1,p2);
		 System.out.println(fetchbook);
		 break;
		 
	 case 6:
		 System.out.println("Enter ISBN Code");
		 int code = scanner.nextInt();
		 Author auth3=authser.fetchById(code);
		System.out.println(auth3);
		break;
	     
	 case 7:
		 System.out.println("Thankyou");
		 System.exit(0);
		 
	 }
	 }
	 }
}
