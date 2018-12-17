package zhumeng.zyhs.ssm.pojo;

public class Television extends Goods{
     
    private Integer Id;
	
	/*private Double goodsPrice;
	
	private Integer goodsLevelId;    //数据字典父类Id  表示该商品属于那一类别	
	
	private String goodsType;     // 商品二级分类种类  及商品名称

	private String introduce; 
	
	private String imageUrl;*/
	
	private Integer size;
	
	//private String missing;
    

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Television() {
		super();
	}

	@Override
	public String toString() {
		return "Television [Id=" + Id + ", size=" + size + "]"+super.toString();
	}
   
	
	
}
