package admin.DTO.notice;

public class NoticeDTO {
    private int ann_seq;      // 공지사항 번호
    private String class_id;  // 분류 ID
    private String ann_title; // 제목
    private String ann_regi;  // 등록일
    private int ann_check;    // 조회수
    private String ann_detail;// 내용
    private String ann_attach;// 첨부파일

    public NoticeDTO() {}

    public int getAnn_seq() {
        return ann_seq;
    }

    public void setAnn_seq(int ann_seq) {
        this.ann_seq = ann_seq;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getAnn_title() {
        return ann_title;
    }

    public void setAnn_title(String ann_title) {
        this.ann_title = ann_title;
    }

    public String getAnn_regi() {
        return ann_regi;
    }

    public void setAnn_regi(String ann_regi) {
        this.ann_regi = ann_regi;
    }

    public int getAnn_check() {
        return ann_check;
    }

    public void setAnn_check(int ann_check) {
        this.ann_check = ann_check;
    }

    public String getAnn_detail() {
        return ann_detail;
    }

    public void setAnn_detail(String ann_detail) {
        this.ann_detail = ann_detail;
    }

    public String getAnn_attach() {
        return ann_attach;
    }

    public void setAnn_attach(String ann_attach) {
        this.ann_attach = ann_attach;
    }

    @Override
    public String toString() {
        return "NoticeDTO [ann_seq=" + ann_seq + ", class_id=" + class_id + ", ann_title=" + ann_title 
            + ", ann_regi=" + ann_regi + ", ann_check=" + ann_check + ", ann_detail=" + ann_detail 
            + ", ann_attach=" + ann_attach + "]";
    }
}
