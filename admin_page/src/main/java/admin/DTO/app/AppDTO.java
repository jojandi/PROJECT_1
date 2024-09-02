package admin.DTO.app;

public class AppDTO {

	private int ann_seq; // 도서신청 번호
	private String app_book; // 도서명
	private String app_name; // 저자
	private String app_pub; //출판사
	private int app_date; //신청일
	private String user_seq; // 회원번호

	public int getAnn_seq() {
		return ann_seq;
	}

	public void setAnn_seq(int ann_seq) {
		this.ann_seq = ann_seq;
	}

	public String getApp_book() {
		return app_book;
	}

	public void setApp_book(String app_book) {
		this.app_book = app_book;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

    public String getApp_pub() {
        return app_pub;
    }

    public void setApp_pub(String app_pub) {
        this.app_pub = app_pub;
    }

	public int getApp_date() {
		return app_date;
	}

	public void setApp_date(int app_date) {
		this.app_date = app_date;
	}

	public String getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}

	@Override
	public String toString() {
		return "AppDTO [ann_seq=" + ann_seq + ", app_book=" + app_book
				+ ", app_name=" + app_name + ", app_pub=" + app_pub
				+ ", app_date=" + app_date + ", user_seq=" + user_seq
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
