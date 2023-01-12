package task01.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import task01.Subscribe;

public class SubscribeMapper {

	public static Subscribe map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int userId = result.getInt("user_id");
		int magazineId = result.getInt("magazine_id");
		boolean subscribeStatus = result.getBoolean("subscribe_status");
		LocalDate subscribeDate = result.getDate("subscribe_date").toLocalDate();
		int subscribePeriod = result.getInt("subscribe_period");
		
		return new Subscribe(id, userId, magazineId, subscribeStatus, subscribeDate, subscribePeriod);
	}
	
}