package zhumeng.zyhs.ssm.pojo;

public class CommonGoods extends Goods{
      
	private Integer Id;
	
	//private Double goodsPrice;
	
	//private Integer goodsLevelId;    //数据字典父类Id  表示该商品属于那一类别	
	
	//private String goodsType;     // 商品二级分类种类  及商品名称
	
	private Double goodNum;
	
	//private String introduce; 
	
	//private String imageUrl;
	
	private Integer payType;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
	/*public Integer getGoodsLevelId() {
		return goodsLevelId;
	}

	public void setGoodsLevelId(Integer goodsLevelId) {
		this.goodsLevelId = goodsLevelId;
	}
*/

	public Double getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Double goodNum) {
		this.goodNum = goodNum;
	}


	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}
    
	
	/*public CommonGoods(String goodsType, Double goodsPrice, String introduce, String imageUrl, Integer id,
			Integer goodsLevelId, Double goodNum, Integer payType) {
		super(goodsType, goodsPrice, introduce, imageUrl, missing);
		Id = id;
		this.goodsLevelId = goodsLevelId;
		this.goodNum = goodNum;
		this.payType = payType;
	}*/
	

	public CommonGoods(){
		super();
	}

	@Override
	public String toString() {
		return "CommonGoods [Id=" + Id + ", goodNum=" + goodNum + ", payType=" + payType + "]"+super.toString();
	}

}
