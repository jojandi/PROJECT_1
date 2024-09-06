package user.dto.bookflix;

import java.util.Date;

public class BookflixDTO {
	private long book_isbn;
	private String book_name;
	private String book_author;
	private String book_pub;
	private String book_img;
	private String li_book_info;
	private String pub_id; // 구매처
	private long bom_code;
	private String bom_name;
	private long mes_book_code;
	private int like_id;
	private int user_seq;
	private String user_name;
	private boolean user_sub;
	
	public String getLi_book_info() {
		return li_book_info;
	}
	public void setLi_book_info(String li_book_info) {
		this.li_book_info = li_book_info;
	}
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public boolean isUser_sub() {
		return user_sub;
	}
	public void setUser_sub(boolean user_sub) {
		this.user_sub = user_sub;
	}
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
	public String getPub_id() {
		return pub_id;
	}
	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}
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
	public long getMes_book_code() {
		return mes_book_code;
	}
	public void setMes_book_code(long mes_book_code) {
		this.mes_book_code = mes_book_code;
	}
	@Override
	public String toString() {
		return "BookflixDTO [book_isbn=" + book_isbn + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_pub=" + book_pub + ", book_img=" + book_img + ", li_book_info=" + li_book_info + ", pub_id="
				+ pub_id + ", bom_code=" + bom_code + ", bom_name=" + bom_name + ", mes_book_code=" + mes_book_code
				+ ", like_id=" + like_id + ", user_seq=" + user_seq + ", user_name=" + user_name + ", user_sub="
				+ user_sub + "]";
	}
	
}
