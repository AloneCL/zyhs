package zhumeng.zyhs.ssm.pojo;

public class MissingTools {
    private Integer Id;
    
    private Integer levelId;      //表示该零件属于哪一大类
    
    private Integer belongsId;   //表示该零件附属类Id
    
    private String toolsName;
    
    private Double toolsPrice;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Integer getBelongsId() {
		return belongsId;
	}

	public void setBelongsId(Integer belongsId) {
		this.belongsId = belongsId;
	}

	public String getToolsName() {
		return toolsName;
	}

	public void setToolsName(String toolsName) {
		this.toolsName = toolsName;
	}

	public Double getToolsPrice() {
		return toolsPrice;
	}

	public void setToolsPrice(Double toolsPrice) {
		this.toolsPrice = toolsPrice;
	}

	@Override
	public String toString() {
		return "MissingTools [Id=" + Id + ", levelId=" + levelId + ", belongsId=" + belongsId + ", toolsName="
				+ toolsName + ", toolsPrice=" + toolsPrice + "]";
	}
    
    
}
