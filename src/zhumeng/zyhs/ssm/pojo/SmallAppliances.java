package zhumeng.zyhs.ssm.pojo;

public class SmallAppliances extends Goods{
    
	private Integer Id;
	
	/*private Double goodsPrice;
	
	private Integer goodsLevelId;    //数据字典父类Id  表示该商品属于那一类别	
	
	private String goodsType;     // 商品二级分类种类  及商品名称
	*/
	private Double goodNum;
	
/*	private String introduce; 
	
	private String imageUrl;*/
	
	private Integer complete;
	
	//private String missing;
    
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Double getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Double goodNum) {
		this.goodNum = goodNum;
	}

  
	public Integer getComplete() {
		return complete;
	}

	public void setComplete(Integer complete) {
		this.complete = complete;
	}

	public SmallAppliances() {
		super();
	}

	@Override
	public String toString() {
		return "SmallAppliances [Id=" + Id + ", goodNum=" + goodNum + ", complete=" + complete + "]"+super.toString();
	}

	
	
	
}
