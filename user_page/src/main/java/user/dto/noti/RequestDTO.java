package user.dto.noti;

public class RequestDTO {
	private String app_book; // 도서명
	private String app_name; // 저자
	private String app_pub; //출판사
	
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

    
	@Override
	public String toString() {
		return "RequestDTO [app_book=" + app_book + ", app_name=" + app_name
				+ ", app_pub=" + app_pub + ", getApp_book()=" + getApp_book()
				+ ", getApp_name()=" + getApp_name() + ", getApp_pub()="
				+ getApp_pub() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
   
}