package task01;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import task01.DAO.MagazineDAO;
import task01.DAO.SubscribeDAO;
import task01.DAO.UserDAO;

public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		// USER INSERT
		UserDAO userDAO = new UserDAO(ConnectionUtils.openConnection());
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("John", "Miller", "john_miller@gmail.com","1111","USER"));
		userList.add(new User("Peter", "Smith", "peter_smith@gmail.com","1111","USER"));
		userList.add(new User("David", "Brown", "david_brown@gmail.com","1111","USER"));
		userList.add(new User("Joseph", "Rodriguez", "joseph_rodriguez@gmail.com","1111","USER"));
		userList.add(new User("Christopher", "Hernandez", "cristopher_hernandez@gmail.com","1111","USER"));
		System.out.println("List of users after adding:");
		userList.forEach(user -> {
			try {
				userDAO.insertUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		userDAO.readAll().stream().forEach(System.out::println);

		// USER READ_BY_ID
		User userFromDB = userDAO.readById(1);
		System.out.println("\nID search result :\n" + userFromDB);

		// USER UPDATE
		userFromDB.setLastName(userFromDB.getLastName() + "-Anderson");
		userDAO.update(userFromDB);
		System.out.println("\nUser after update :\n" + userFromDB);

		// USER DELETE
		userDAO.delete(1);
		System.out.println("\nList of users after deleting:");
		userDAO.readAll().stream().forEach(System.out::println);

		// MAGAZINE INSERT
		MagazineDAO magazineDAO = new MagazineDAO(ConnectionUtils.openConnection());
		System.out.println("\nList of magazines after adding to the database:");
		magazineDAO.insertMagazine(new Magazine("Car", LocalDate.parse("2019-10-22"), 60.99));
		magazineDAO.insertMagazine(new Magazine("Fashion", LocalDate.parse("2022-01-20"), 99.89));
		magazineDAO.insertMagazine(new Magazine("News", LocalDate.parse("2022-12-13"), 53.59));
		magazineDAO.insertMagazine(new Magazine("Cooking", LocalDate.parse("2015-09-23"), 119.89));
		magazineDAO.insertMagazine(new Magazine("Art", LocalDate.parse("2018-07-07"), 177.89));
		magazineDAO.readAll().stream().forEach(System.out::println);

		// MAGAZINE READ_BY_ID
		Magazine magazineFromDB = magazineDAO.readById(1);
		System.out.println("\nID search result :\n" + magazineFromDB);

		// MAGAZINE UPDATE
		magazineFromDB.setSubscribePrice(89.90);
		magazineDAO.update(magazineFromDB);
		System.out.println("\nMagazine after update :\n" + magazineFromDB);

		// MAGAZINE DELETE
		magazineDAO.delete(1);
		System.out.println("\nList of magazines after deleting:");
		magazineDAO.readAll().stream().forEach(System.out::println);

		// SUBSCRIBE INSERT
		SubscribeDAO subscribeDAO = new SubscribeDAO(ConnectionUtils.openConnection());
		System.out.println("\nList of subscribes after adding to the database:");
		subscribeDAO.insertSubscribe(new Subscribe(2, 2, true, LocalDate.parse("2019-11-20"), 6));
		subscribeDAO.insertSubscribe(new Subscribe(3, 5, true, LocalDate.parse("2020-09-13"), 9));
		subscribeDAO.insertSubscribe(new Subscribe(5, 4, true, LocalDate.parse("2021-04-23"), 2));
		subscribeDAO.readAll().stream().forEach(System.out::println);

		// SUBSCRIBE READ_BY_ID
		Subscribe subscribeFromDB = subscribeDAO.readById(1);
		System.out.println("\nID search result :\n" + subscribeFromDB);

		// SUBSCRIBE UPDATE
		subscribeFromDB.setSubscribePeriod(12);
		subscribeDAO.update(subscribeFromDB);
		System.out.println("\nSubscribe after update :\n" + subscribeFromDB);

		// SUBSCRIBE DELETE
		subscribeDAO.delete(1);
		System.out.println("\nList of subscribes after deleting:");
		subscribeDAO.readAll().stream().forEach(System.out::println);
	}

}