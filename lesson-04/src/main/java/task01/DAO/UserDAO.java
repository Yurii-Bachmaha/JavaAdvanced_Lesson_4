package task01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import task01.User;
import task01.Mappers.UserMapper;

public class UserDAO {

	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`first_name`,`last_name`,`email`,`password`,`access_level`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id=?";
	private static String UPDATE_BY_ID = "update user set first_name=?, last_name=?, email=?, password=?, access_level=? where id=?";
	private static String DELETE_BY_ID = "delete from user where id=?";

	private Connection connection;
	private PreparedStatement statement;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	public List<User> readAll() throws SQLException {
		List<User> listOfUsers = new ArrayList<>();
		statement = connection.prepareStatement(READ_ALL);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			listOfUsers.add(UserMapper.map(result));
		}
		return listOfUsers;
	}

	public void insertUser(User user) throws SQLException {
		statement = connection.prepareStatement(CREATE);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getAccessLevel());
		statement.executeUpdate();
	}

	public User readById(int id) throws SQLException {
		statement = connection.prepareStatement(READ_BY_ID);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		result.next();
		return UserMapper.map(result);
	}

	public void update(User user) throws SQLException {
		statement = connection.prepareStatement(UPDATE_BY_ID);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getAccessLevel());
		statement.setInt(6, user.getId());
		statement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		statement = connection.prepareStatement(DELETE_BY_ID);
		statement.setInt(1, id);
		statement.executeUpdate();
	}
	
}