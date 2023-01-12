package task01;

import java.time.LocalDate;

public class Subscribe {

	private int id;
	private int userId;
	private int magazineId;
	private boolean subscribeStatus;
	private LocalDate subscribeDate;
	private int subscribePeriod;

	public Subscribe(int id, int userId, int magazineId, boolean subscribeStatus, LocalDate subscribeDate,
			int subscribePeriod) {
		super();
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public Subscribe(int userId, int magazineId, boolean subscribeStatus, LocalDate subscribeDate,
			int subscribePeriod) {
		super();
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

	public boolean isSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(boolean subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public LocalDate getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(LocalDate subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public int getSubscribePeriod() {
		return subscribePeriod;
	}

	public void setSubscribePeriod(int subscribePeriod) {
		this.subscribePeriod = subscribePeriod;
	}

	@Override
	public String toString() {
		return "Subscribe id = " + id + ", userId = " + userId + ", magazineId = " + magazineId + ", subscribeStatus = "
				+ subscribeStatus + ", subscribeDate = " + subscribeDate + ", subscribePeriod = " + subscribePeriod + " months";
	}
	
}