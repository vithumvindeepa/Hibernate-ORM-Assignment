import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Main main = new Main();

    L1:    do {
            main.questions();

            int number = input.nextInt();

            if (number == 1) {
                System.out.print("enter book's name : ");
                String bookName = input.next();

                System.out.println("");

                System.out.print("enter book's tittle : ");
                String tittle = input.next();

                System.out.println("");

                System.out.print("enter book's price : ");
                double price = input.nextDouble();

                System.out.println("");

                Book book = new Book(bookName, tittle, price);
                session.persist(book);

                transaction.commit();
                session.beginTransaction();

                System.out.println("book save successsfully...");

                System.out.print("Do you want to continue(y/n) ? : ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("y")) {
                    continue L1;
                } else {
                       System.exit(0);
                }

            } else if (number == 2) {
                System.out.print("enter book's id : ");
                int bookId = input.nextInt();

                Book book = session.get(Book.class, bookId);

                transaction.commit();
                session.beginTransaction();

                System.out.println("id : " + book.getBookId() + ", name : " + book.getBookName() + ", tittle : " + book.getTittle() + ", price : " + book.getPrice());

                System.out.print("Do you want to continue(y/n) ? : ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("y")) {
                    continue L1;
                } else {
                    System.exit(0);
                }

            } else if (number == 3) {
                System.out.print("enter book's id : ");
                int bookId = input.nextInt();

                Book book = session.load(Book.class, bookId);

                System.out.print("enter book's name : ");
                String bookName = input.next();

                System.out.println("");

                System.out.print("enter book's tittle : ");
                String tittle = input.next();

                System.out.println("");

                System.out.println("enter book's price : ");
                double price = input.nextDouble();

                book.setBookName(bookName);
                book.setTittle(tittle);
                book.setPrice(price);

                session.update(book);

                transaction.commit();
                session.beginTransaction();

                System.out.println("book update successfully...");

                System.out.print("Do you want to continue(y/n) ? : ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("y")) {
                    continue L1;
                } else {
                    System.exit(0);
                }

            } else if (number == 4) {
                System.out.print("enter book's id : ");
                int bookId = input.nextInt();

                Book book = session.load(Book.class, bookId);

                session.delete(book);
                transaction.commit();
                session.beginTransaction();

                System.out.println("book delete successfully...");

                System.out.print("Do you want to continue(y/n) ? ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("y")) {
                    continue L1;
                } else {
                    System.exit(0);
                }

            } else {
                System.out.println("Please Enter Correct Number!");
            }

            transaction.commit();
        }while (true);
    }

        public void questions () {
            System.out.println("save a new book? press number 1 ;");
            System.out.println("get book by id? press number 2 ;");
            System.out.println("update book by id? press number ;");
            System.out.println("delete book? press number 4 ;");
        }
    }
