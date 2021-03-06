import model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class CoraCardManager {
    public static void main(String[] args) {
        System.out.println("START PROGRAM");

        createUser();

//        System.out.println("GET ALL USER: ");
//        List<User> users = getAllUser();
//        for (User u : users) {
//            System.out.println(u);
//        }
//
//        System.out.println(getUserById(2));


        System.out.println("END PROGRAM");
        HibernateUtil.getSessionFactory().close();
    }

    public static List<User> getAllUser() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String queryString = "FROM User";
            Query query = session.createQuery(queryString);
            List<User> userList = (List<User>) query.list();
            return userList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static User getUserById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("userId", id));
            List<User> users = (List<User>) userCriteria.list();
            return users.get(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void createUser() {

        User user1 = new User("truongnq", "123456", "truong@gmail.com", "Quang Trường", "Handsome");
        User user2 = new User("dungdt", "123456", "dung@gmail.com", "Dương Dũng", "Xấu trai");
        User user3 = new User("oanhvl", "123456", "oanh@gmail.com", "Lâm Oanh", "Xấu gái");

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user1);
            session.save(user2);
            session.save(user3);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
