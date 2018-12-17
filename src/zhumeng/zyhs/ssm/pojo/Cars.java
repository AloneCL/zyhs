package zhumeng.zyhs.ssm.pojo;

import java.util.List;

public class Cars extends Goods{
    
    private Integer Id;
	
	//private Double goodsPrice;
	
	//private Integer goodsLevelId;    //数据字典父类Id  表示该商品属于那一类别	
	
	//private String goodsType;     // 商品二级分类种类  及商品名称
	
	private Double goodNum;
	
	//private String introduce; 
	
	//private String imageUrl;
	
	private Integer carType;
	
	//private List<MissingTools> missing;
    
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	/*public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsLevelId() {
		return goodsLevelId;
	}

	public void setGoodsLevelId(Integer goodsLevelId) {
		this.goodsLevelId = goodsLevelId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
*/
	public Double getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Double goodNum) {
		this.goodNum = goodNum;
	}

	/*public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}*/

	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	public Cars() {
		super();
	}

	@Override
	public String toString() {
		return "Cars [Id=" + Id + ", goodNum=" + goodNum + ", carType=" + carType + "]"+super.toString();
	}

	


	/*public List<MissingTools> getMissing() {
		return missing;
	}

	public void setMissing(List<MissingTools> missing) {
		this.missing = missing;
	}*/

	
	
}
