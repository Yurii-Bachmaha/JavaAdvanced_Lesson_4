package task01.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import task01.Subscribe;
import task01.Mappers.SubscribeMapper;

public class SubscribeDAO {

	private static String READ_ALL = "select * from subscribe";
	private static String CREATE = "insert into subscribe(`user_id`,`magazine_id`,`subscribe_status`,`subscribe_date`,`subscribe_period`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from subscribe where id=?";
	private static String UPDATE_BY_ID = "update subscribe set user_id=?, magazine_id=?, subscribe_status=?, subscribe_date=?, subscribe_period=? where id=?";
	private static String DELETE_BY_ID = "delete from subscribe where id=?";
	
	private Connection connection;
	private PreparedStatement statement;

	public SubscribeDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Subscribe> readAll() throws SQLException {
		List<Subscribe> listOfSubscribes = new ArrayList<>();
		statement = connection.prepareStatement(READ_ALL);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			listOfSubscribes.add(SubscribeMapper.map(result));
		}
		return listOfSubscribes;
	}
	
	public void insertSubscribe(Subscribe subscribe) {
		try {
			statement = connection.prepareStatement(CREATE);
			statement.setInt(1, subscribe.getUserId());
			statement.setInt(2, subscribe.getMagazineId());
			statement.setBoolean(3, subscribe.isSubscribeStatus());
			statement.setDate(4, Date.valueOf(subscribe.getSubscribeDate()));
			statement.setInt(5, subscribe.getSubscribePeriod());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Subscribe readById(int id) throws SQLException {
		statement = connection.prepareStatement(READ_BY_ID);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		result.next();

		return SubscribeMapper.map(result);
	}
	
	public void update(Subscribe subscribe) throws SQLException {
		statement = connection.prepareStatement(UPDATE_BY_ID);
		statement.setInt(1, subscribe.getUserId());
		statement.setInt(2, subscribe.getMagazineId());
		statement.setBoolean(3, subscribe.isSubscribeStatus());
		statement.setDate(4, Date.valueOf(subscribe.getSubscribeDate()));
		statement.setInt(5, subscribe.getSubscribePeriod());
		statement.setInt(6, subscribe.getId());
		statement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		statement = connection.prepareStatement(DELETE_BY_ID);
		statement.setInt(1, id);
		statement.executeUpdate();
	}
	
}