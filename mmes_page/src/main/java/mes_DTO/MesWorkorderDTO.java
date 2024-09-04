package mes_DTO;

public class MesWorkorderDTO {
	private Integer bom_code;
	private String bom_name;
	private Integer mes_book_code1;
	private Integer mes_book_code2;
	private Integer mes_book_code3;
	private long book_isbn;
	private String book_name;
	private String book_author;
	private String book_pub;
	private String book_img;
	private Integer mes_book_code;
	private long book_count;
	private String wh_code;
	private Integer mes_book_price;
	
	
	
	
	public String getBom_name() {
		return bom_name;
	}
	public void setBom_name(String bom_name) {
		this.bom_name = bom_name;
	}
	public void setBook_isbn(long book_isbn) {
		this.book_isbn = book_isbn;
	}
	public void setBook_count(long book_count) {
		this.book_count = book_count;
	}
	public Long getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(Long  book_isbn) {
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
	public Integer getMes_book_code() {
		return mes_book_code;
	}
	public void setMes_book_code(Integer mes_book_code) {
		this.mes_book_code = mes_book_code;
	}
	public Long getBook_count() {
		return book_count;
	}
	public void setBook_count(Long book_count) {
		this.book_count = book_count;
	}
	public String getWh_code() {
		return wh_code;
	}
	public void setWh_code(String wh_code) {
		this.wh_code = wh_code;
	}
	public Integer getMes_book_price() {
		return mes_book_price;
	}
	public void setMes_book_price(Integer mes_book_price) {
		this.mes_book_price = mes_book_price;
	}
	public Integer getBom_code() {
		return bom_code;
	}
	public void setBom_code(Integer bom_code) {
		this.bom_code = bom_code;
	}
	
	public Integer getMes_book_code1() {
		return mes_book_code1;
	}
	public void setMes_book_code1(Integer mes_book_code1) {
		this.mes_book_code1 = mes_book_code1;
	}
	public Integer getMes_book_code2() {
		return mes_book_code2;
	}
	public void setMes_book_code2(Integer mes_book_code2) {
		this.mes_book_code2 = mes_book_code2;
	}
	public Integer getMes_book_code3() {
		return mes_book_code3;
	}
	public void setMes_book_code3(Integer mes_book_code3) {
		this.mes_book_code3 = mes_book_code3;
	}
	
	
	@Override
	public String toString() {
		return "MesWorkorderDTO [bom_code=" + bom_code + ", mes_book_code1=" + mes_book_code1 + ", mes_book_code2="
				+ mes_book_code2 + ", mes_book_code3=" + mes_book_code3 + ", book_isbn=" + book_isbn + ", book_name="
				+ book_name + ", book_author=" + book_author + ", book_pub=" + book_pub + ", book_img=" + book_img
				+ ", mes_book_code=" + mes_book_code + ", book_count=" + book_count + ", wh_code=" + wh_code
				+ ", mes_book_price=" + mes_book_price + ", bom_name=" + bom_name + "]";
	}
}
