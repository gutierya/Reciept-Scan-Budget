package directory.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long receiptId;

	@OneToMany(mappedBy = "receipt")
	private List<DataItem> dataItems;

	@ManyToOne
	private User user;

	private Double total;
	private String imageUrl;
	private String businessName;
	private Integer date;

	public Receipt() {

	}

	public Receipt(Double total, Long receiptId, String imageUrl, String businessName, Integer date, List<DataItem> dataItems) {
		this.total = total;
		this.receiptId = receiptId;
		this.imageUrl = imageUrl;
		this.businessName = businessName;
		this.date = date;
		this.dataItems = dataItems;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public List<DataItem> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<DataItem> dataItems) {
		this.dataItems = dataItems;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Receipt receipt = (Receipt) o;
		return Double.compare(receipt.total, total) == 0 && receiptId == receipt.receiptId && date == receipt.date && Objects.equals(imageUrl, receipt.imageUrl) && Objects.equals(businessName, receipt.businessName) && Objects.equals(dataItems, receipt.dataItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(total, receiptId, imageUrl, businessName, date, dataItems);
	}

	@Override
	public String toString() {
		return "Receipt{" +
				"total=" + total +
				", receiptId=" + receiptId +
				", imageUrl='" + imageUrl + '\'' +
				", businessName='" + businessName + '\'' +
				", date=" + date +
				", dataItems=" + dataItems +
				'}';
	}
}