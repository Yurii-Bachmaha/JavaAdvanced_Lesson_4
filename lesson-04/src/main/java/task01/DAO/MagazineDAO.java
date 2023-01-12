package task01.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import task01.Magazine;
import task01.Mappers.MagazineMapper;

public class MagazineDAO {

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`name`,`publish_date`,`subscribe_price`) values (?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id=?";
	private static String UPDATE_BY_ID = "update magazine set name=?, publish_date=?, subscribe_price=? where id=?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";

	private Connection connection;
	private PreparedStatement statement;

	public MagazineDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Magazine> readAll() throws SQLException {
		List<Magazine> listOfMagazines = new ArrayList<>();
		statement = connection.prepareStatement(READ_ALL);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			listOfMagazines.add(MagazineMapper.map(result));
		}
		return listOfMagazines;
	}

	public void insertMagazine(Magazine magazine) {
		try {
			statement = connection.prepareStatement(CREATE);
			statement.setString(1, magazine.getName());
			statement.setDate(2, Date.valueOf(magazine.getPublishDate()));
			statement.setDouble(3, magazine.getSubscribePrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Magazine readById(int id) throws SQLException {
		statement = connection.prepareStatement(READ_BY_ID);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		result.next();

		return MagazineMapper.map(result);
	}

	public void update(Magazine magazine) throws SQLException {
		statement = connection.prepareStatement(UPDATE_BY_ID);
		statement.setString(1, magazine.getName());
		statement.setDate(2, Date.valueOf(magazine.getPublishDate()));
		statement.setDouble(3, magazine.getSubscribePrice());
		statement.setInt(4, magazine.getId());
		statement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		statement = connection.prepareStatement(DELETE_BY_ID);
		statement.setInt(1, id);
		statement.executeUpdate();
	}

}