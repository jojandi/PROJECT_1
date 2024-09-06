package mes_DTO;

import java.sql.Date;

public class MesMainDTO {
	private Integer ds_id;	
	private Integer bom_code;	
	private Integer total_sales;	
	private Integer date_id;
	
	
	public Integer getDs_id() {
		return ds_id;
	}
	public void setDs_id(Integer ds_id) {
		this.ds_id = ds_id;
	}
	public Integer getBom_code() {
		return bom_code;
	}
	public void setBom_code(Integer bom_code) {
		this.bom_code = bom_code;
	}
	public Integer getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(Integer total_sales) {
		this.total_sales = total_sales;
	}
	public Integer getDate_id() {
		return date_id;
	}
	public void setDate_id(Integer date_id) {
		this.date_id = date_id;
	}	
	@Override
	public String toString() {
		return "MesMainDTO [ds_id=" + ds_id + ", bom_code=" + bom_code + ", total_sales=" + total_sales + ", date_id="
				+ date_id + "]";
	}
	
	
}
