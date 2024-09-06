package mes_DTO;

import java.sql.Date;

public class MesMainDTO {
	private Integer ds_id;	
	private Integer bom_code;	
	private Integer total_sales;	
	private Integer date_id;
	 private String genre;  // bom_name
	  public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getDate_id() {
		return date_id;
		
	}
	public void setDate_id(Integer date_id) {
		this.date_id = date_id;
	}

	private int year;
	    private int month;
	    private int total;

	
	
	public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
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
	
	@Override
	public String toString() {
		return "MesMainDTO [ds_id=" + ds_id + ", bom_code=" + bom_code + ", total_sales=" + total_sales + ", date_id="
				+ date_id + "]";
	}
	
	
}
