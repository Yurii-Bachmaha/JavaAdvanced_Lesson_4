package task01.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import task01.Magazine;

public class MagazineMapper {
	
	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		LocalDate publishDate = result.getDate("publish_date").toLocalDate();
		double subscribePrice = result.getDouble("subscribe_price");
		
		return new Magazine(id, name, publishDate, subscribePrice);
	}
	
}