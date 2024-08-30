package admin.DTO.notice;

public class noticeDTO {
	private int id;
    private String category; // 공지사항 카테고리
    private String title;    // 공지사항 제목
    private String date;     // 공지사항 날짜
    private String content;  // 공지사항 내용
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "noticeDTO [id=" + id + ", category=" + category + ", title="
				+ title + ", date=" + date + ", content=" + content + "]";
	}
    
    
    
    
    
}
