package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sale {

	private Integer month, year, items;
	private String seller;
	private Double total;
	List<Double> list = new ArrayList<>();

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		super();
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Sale() {
		super();
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Double getTotal() {
		list.add(total);
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double AveragePrice() {

		return total / items;

	}

	@Override
	public int hashCode() {
		return Objects.hash(total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "month=" + month + ", year=" + year + ", items=" + items + ", seller=" + seller + ", total=" + total
				+ (String.format(", pm : %.2f", AveragePrice()));
	}

}
