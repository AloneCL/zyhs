package zhumeng.zyhs.ssm.pojo;

public class Washing extends Goods{
    
	private Integer Id;
	
	/*private Double goodsPrice;
	
	private Integer goodsLevelId;    //数据字典父类Id  表示该商品属于那一类别	
	
	private String goodsType;     // 商品二级分类种类  及商品名称
	
	private String introduce; 
	
	private String imageUrl;*/
	
	private Integer weight;
	
	//private String missing;
    

	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getWeight() {
		return weight;
	}


	public void setWeight(Integer weight) {
		this.weight = weight;
	}


	public Washing() {
		super();
	}


	@Override
	public String toString() {
		return "Washing [Id=" + Id + ", weight=" + weight + "]"+super.toString();
	}



	
}
