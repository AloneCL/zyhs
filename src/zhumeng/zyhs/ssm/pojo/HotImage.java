package zhumeng.zyhs.ssm.pojo;

public class HotImage {
	private Integer Id;

	private String image1URL;

	private String image2URL;
	
	private String image3URL;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getImage1URL() {
		return image1URL;
	}

	public void setImage1URL(String image1url) {
		image1URL = image1url;
	}

	public String getImage2URL() {
		return image2URL;
	}
    
	public void setImage2URL(String image2url) {
		image2URL = image2url;
	}

	public String getImage3URL() {
		return image3URL;
	}

	public void setImage3URL(String image3url) {
		image3URL = image3url;
	}

	@Override
	public String toString() {
		return "HotImage [Id=" + Id + ", image1URL=" + image1URL + ", image2URL=" + image2URL + ", image3URL="
				+ image3URL + "]";
	}
	
	

}
