package zhumeng.zyhs.ssm.pojo;

public class GoodsLevel {
    private Integer Id;
   
    private Integer level;
    
    private String levelName;
    
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Override
	public String toString() {
		return "GoodsLevel [Id=" + Id + ", level=" + level + ", levelName=" + levelName + "]";
	}
    
    
}
