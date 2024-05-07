package AgriMarketBackend.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cardno;
	private String nameoncard;
	private int amount;
	private Date paymentdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardno=" + cardno + ", nameoncard=" + nameoncard + ", amount=" + amount
				+ ", paymentdate=" + paymentdate + "]";
	}
	
	
	
}
