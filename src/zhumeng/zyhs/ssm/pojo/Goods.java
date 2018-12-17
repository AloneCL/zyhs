package zhumeng.zyhs.ssm.pojo;

import java.util.List;

public class Goods {
	
	private int goodsId;
	
	private String goodsType;        //商品名称
	 
	private Double goodsPrice;       // 商品价格
	
	private String introduce;        // 商品介绍

	private String imageUrl1;        //商品封面图
	
	private String imageUrl2;
	
	private String imageUrl3;
	
	private Integer goodsLevelId; //数据字典父类Id  表示该商品属于那一类别
	
	private Integer blOrderId;
	
	private List<MissingTools> missing; 
    
	private String missingTools;
	
	private String poweratename;   //功率名/英寸名
	private String powerate;        //功率/英寸
	private String brandname;       //品牌名/容量名
	private String brand;           // 品牌/容量
	private String time;           //时间
	private Double num;
	private Double totalPrice;     //商品价格
	private String name;           //商品名称
	
	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public List<MissingTools> getMissing() {
		return missing;
	}

	public void setMissing(List<MissingTools> missing) {
		this.missing = missing;
	}

	
	public Integer getGoodsLevelId() {
		return goodsLevelId;
	}

	public void setGoodsLevelId(Integer goodsLevelId) {
		this.goodsLevelId = goodsLevelId;
	}
	
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	
	public Integer getBlOrderId() {
		return blOrderId;
	}

	public void setBlOrderId(Integer blOrderId) {
		this.blOrderId = blOrderId;
	}

	public String getMissingTools() {
		return missingTools;
	}

	public void setMissingTools(String missingTools) {
		this.missingTools = missingTools;
	}

	public Goods() {
		super();
	}
    
	public String getPoweratename() {
		return poweratename;
	}

	public void setPoweratename(String poweratename) {
		this.poweratename = poweratename;
	}

	public String getPowerate() {
		return powerate;
	}

	public void setPowerate(String powerate) {
		this.powerate = powerate;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}
    
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsType=" + goodsType + ", goodsPrice=" + goodsPrice + ", introduce="
				+ introduce + ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2 + ", imageUrl3=" + imageUrl3
				+ ", goodsLevelId=" + goodsLevelId + ", blOrderId=" + blOrderId + ", missing=" + missing
				+ ", missingTools=" + missingTools + ", poweratename=" + poweratename + ", powerate=" + powerate
				+ ", brandname=" + brandname + ", brand=" + brand + ", time=" + time + ", num=" + num + ", totalPrice="
				+ totalPrice + ", name=" + name + "]";
	}

    
}
