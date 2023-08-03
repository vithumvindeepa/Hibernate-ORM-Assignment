import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Author a1 = new Author();
        a1.setAuthorName("martin");

        Book b1 = new Book();
        b1.setBookName("madoldoowa");
        b1.setTittle("about village");
        b1.setPrice(2000);
        b1.setAuthor(a1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(b1);

        transaction.commit();
        session.close();
    }

}
