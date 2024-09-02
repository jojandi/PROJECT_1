package mes_DTO;

import java.util.Date;

public class MesStockDTO {
	private long book_isbn;
	private String book_name;
	private String book_author;
	private String book_pub;
	private String book_img;
	private long book_count;
	private String wh_code;
	private String wh_name;
	private String wh_add;
	private Date order_date;
	private String order_id;
	private long order_price; // 총 금액
	private long order_count;	// 총 주문 개수
	private String pub_id;
	private long bom_code;
	private String bom_name;
	public long getBom_code() {
		return bom_code;
	}
	public void setBom_code(long bom_code) {
		this.bom_code = bom_code;
	}
	public String getBom_name() {
		return bom_name;
	}
	public void setBom_name(String bom_name) {
		this.bom_name = bom_name;
	}
	public long getPd_count() {
		return pd_count;
	}
	public void setPd_count(long pd_count) {
		this.pd_count = pd_count;
	}
	public String getPd_note() {
		return pd_note;
	}
	public void setPd_note(String pd_note) {
		this.pd_note = pd_note;
	}
	private	 long pd_count;
	private String pd_note;
	
	public String getPub_id() {
		return pub_id;
	}
	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public long getOrder_count() {
		return order_count;
	}
	public void setOrder_count(long order_count) {
		this.order_count = order_count;
	}
	@Override
	public String toString() {
		return "MesStockDTO [book_isbn=" + book_isbn + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_pub=" + book_pub + ", book_img=" + book_img + ", book_count=" + book_count + ", wh_code="
				+ wh_code + ", wh_name=" + wh_name + ", wh_add=" + wh_add + ", order_date=" + order_date + ", order_id="
				+ order_id + ", order_price=" + order_price + ", order_count=" + order_count + ", pub_id=" + pub_id
				+ ", bom_code=" + bom_code + ", bom_name=" + bom_name + ", pd_count=" + pd_count + ", pd_note="
				+ pd_note + ", order_st=" + order_st + ", mes_book_code=" + mes_book_code + ", emp_name=" + emp_name
				+ ", pub_name=" + pub_name + "]";
	}
	private String order_st;
	private long mes_book_code;
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public long getOrder_price() {
		return order_price;
	}
	public void setOrder_price(long order_price) {
		this.order_price = order_price;
	}
	public String getOrder_st() {
		return order_st;
	}
	public void setOrder_st(String order_st) {
		this.order_st = order_st;
	}
	public long getMes_book_code() {
		return mes_book_code;
	}
	public void setMes_book_code(long mes_book_code) {
		this.mes_book_code = mes_book_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPub_name() {
		return pub_name;
	}
	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}
	private String emp_name;
	private String pub_name;
	
	
	public long getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(long book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_pub() {
		return book_pub;
	}
	public void setBook_pub(String book_pub) {
		this.book_pub = book_pub;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public long getBook_count() {
		return book_count;
	}
	public void setBook_count(long book_count) {
		this.book_count = book_count;
	}
	public String getWh_code() {
		return wh_code;
	}
	public void setWh_code(String wh_code) {
		this.wh_code = wh_code;
	}
	public String getWh_name() {
		return wh_name;
	}
	public void setWh_name(String wh_name) {
		this.wh_name = wh_name;
	}
	public String getWh_add() {
		return wh_add;
	}
	public void setWh_add(String wh_add) {
		this.wh_add = wh_add;
	}
	
	
}
