import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setTittle("about village");
        b1.setBookName("madoldoowa");
        b1.setPrice(2000);

        Book b2 = new Book();
        b2.setTittle("about village2");
        b2.setBookName("apeGama");
        b2.setPrice(3000);

        Author a1 = new Author();
        a1.setAuthorName("kumarathunga");

        Author a2 = new Author();
        a2.setAuthorName("martin wickramasinghe");

        b1.getAuthor().add(a1);
        b1.getAuthor().add(a2);

        b2.getAuthor().add(a2);
        b2.getAuthor().add(a1);

        a1.getBook().add(b1);
        a1.getBook().add(b2);

        a2.getBook().add(b2);
        a2.getBook().add(b1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(b1);
        session.persist(b2);

        transaction.commit();
        session.close();
    }

}
