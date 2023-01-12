package task01;

import java.time.LocalDate;

public class Magazine {

	private int id;
	private String name;
	private LocalDate publishDate;
	private double subscribePrice;

	public Magazine(int id, String name, LocalDate publishDate, double subscribePrice) {
		super();
		this.id = id;
		this.name = name;
		this.publishDate = publishDate;
		this.subscribePrice = subscribePrice;
	}

	public Magazine(String name, LocalDate publishDate, double subscribePrice) {
		super();
		this.name = name;
		this.publishDate = publishDate;
		this.subscribePrice = subscribePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getSubscribePrice() {
		return subscribePrice;
	}

	public void setSubscribePrice(double subscribePrice) {
		this.subscribePrice = subscribePrice;
	}

	@Override
	public String toString() {
		return "Magazine id = " + id + ", name = " + name + ", publishDate = " + publishDate + ", subscribePrice = "
				+ subscribePrice;
	}

}