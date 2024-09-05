package user.dto.best;

public class BestDTO {
	private int book_code;
	private String li_book_info;
	private long book_ISBN;
	private String book_name;
	private String book_author;
	private String book_img;
	private String book_pub;
	private int count;
	private int book_loan_seq;
	private boolean book_loan;
	private boolean book_res;
	
	@Override
	public String toString() {
		return "BestDTO [book_code=" + book_code + ", li_book_info=" + li_book_info + ", book_ISBN=" + book_ISBN
				+ ", book_name=" + book_name + ", book_author=" + book_author + ", book_img=" + book_img + ", book_pub="
				+ book_pub + ", count=" + count + ", book_loan_seq=" + book_loan_seq + ", book_loan=" + book_loan
				+ ", book_res=" + book_res + "]";
	}
	
	public int getBook_code() {
		return book_code;
	}
	public void setBook_code(int book_code) {
		this.book_code = book_code;
	}
	public String getLi_book_info() {
		return li_book_info;
	}
	public void setLi_book_info(String li_book_info) {
		this.li_book_info = li_book_info;
	}
	public long getBook_ISBN() {
		return book_ISBN;
	}
	public void setBook_ISBN(long book_ISBN) {
		this.book_ISBN = book_ISBN;
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
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_pub() {
		return book_pub;
	}
	public void setBook_pub(String book_pub) {
		this.book_pub = book_pub;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBook_loan_seq() {
		return book_loan_seq;
	}
	public void setBook_loan_seq(int book_loan_seq) {
		this.book_loan_seq = book_loan_seq;
	}
	public boolean isBook_loan() {
		return book_loan;
	}
	public void setBook_loan(boolean book_loan) {
		this.book_loan = book_loan;
	}
	public boolean isBook_res() {
		return book_res;
	}
	public void setBook_res(boolean book_res) {
		this.book_res = book_res;
	}
}
