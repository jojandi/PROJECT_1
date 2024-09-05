package user.dto.noti;

public class NotiDTO {
    private int ann_Seq; 
    private int class_Id; 
    private String ann_Title; 
    private String ann_Regi; 
    private String class_name; 
    private int ann_Check;
    private String ann_Detail;

    public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
    
    public String getAnn_Detail() {
		return ann_Detail;
	}
	public void setAnn_Detail(String ann_Detail) {
		this.ann_Detail = ann_Detail;
	}
	public int getAnn_Seq() {
		return ann_Seq;
	}
	public void setAnn_Seq(int ann_Seq) {
		this.ann_Seq = ann_Seq;
	}
	public int getClass_Id() {
		return class_Id;
	}
	public void setClass_Id(int class_Id) {
		this.class_Id = class_Id;
	}
	public String getAnn_Title() {
		return ann_Title;
	}
	public void setAnn_Title(String ann_Title) {
		this.ann_Title = ann_Title;
	}
	public String getAnn_Regi() {
		return ann_Regi;
	}
	public void setAnn_Regi(String ann_Regi) {
		this.ann_Regi = ann_Regi;
	}
	
	public int getAnn_Check() {
		return ann_Check;
	}
	public void setAnn_Check(int ann_Check) {
		this.ann_Check = ann_Check;
	}
	@Override
	public String toString() {
		return "NotiDTO [ann_Seq=" + ann_Seq + ", class_Id=" + class_Id
				+ ", ann_Title=" + ann_Title + ", ann_Regi=" + ann_Regi
				+ ", class_name=" + class_name + ", ann_Check=" + ann_Check
				+ ", ann_Detail=" + ann_Detail + "]";
	}
  
    
   
}