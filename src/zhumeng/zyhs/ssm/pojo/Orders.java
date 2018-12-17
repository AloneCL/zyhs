package zhumeng.zyhs.ssm.pojo;

import java.util.List;

public class Orders {
    private Integer id;
    
    private String orderIdentifier;   //订单编号 
    
    private String releaseTime;
    
    private String orderTime;
    
    private String finishTime;
    
    private Integer userId;        //卖家id
    
    private String userName;      //卖家昵称
    
    private String userTel;         //卖家的联系方式
    
    private Integer orderUserId;   //买家id
    
    private String orderUserTel;    //买家电话
        
    private String OrderUserName;    // 买家昵称
    
    private String address;       //用户的取货地址
    
    private Double longitude;         //用户定位的经度

    private Double latitude;          //用户定位的纬度
    
    private List<Goods> good;    //一对多关联
    
    private Integer userOrderStatus;    // 表示卖家的订单状态
    
    private Integer orderUserOrderStatus;  // 表示买家的订单状态
    
    private Integer orderManner;
    
    private Double orderMoney;
    
    private Integer orderStatus;
    
    private String imageUrl;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderManner() {
		return orderManner;
	}

	public void setOrderManner(Integer orderManner) {
		this.orderManner = orderManner;
	}

	public Double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	public List<Goods> getGood() {
		return good;
	}

	public void setGood(List<Goods> good) {
		this.good = good;
	}

	public Integer getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(Integer orderUserId) {
		this.orderUserId = orderUserId;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	public String getOrderIdentifier() {
		return orderIdentifier;
	}

	public String getOrderUserTel() {
		return orderUserTel;
	}

	public void setOrderUserTel(String orderUserTel) {
		this.orderUserTel = orderUserTel;
	}

	public String getOrderUserName() {
		return OrderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		OrderUserName = orderUserName;
	}

	public void setOrderIdentifier(String orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}

	public Integer getUserOrderStatus() {
		return userOrderStatus;
	}

	public void setUserOrderStatus(Integer userOrderStatus) {
		this.userOrderStatus = userOrderStatus;
	}

	public Integer getOrderUserOrderStatus() {
		return orderUserOrderStatus;
	}

	public void setOrderUserOrderStatus(Integer orderUserOrderStatus) {
		this.orderUserOrderStatus = orderUserOrderStatus;
	}
   
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderIdentifier=" + orderIdentifier + ", releaseTime=" + releaseTime
				+ ", orderTime=" + orderTime + ", finishTime=" + finishTime + ", userId=" + userId + ", userName="
				+ userName + ", userTel=" + userTel + ", orderUserId=" + orderUserId + ", orderUserTel=" + orderUserTel
				+ ", OrderUserName=" + OrderUserName + ", address=" + address + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", good=" + good + ", userOrderStatus=" + userOrderStatus
				+ ", orderUserOrderStatus=" + orderUserOrderStatus + ", orderManner=" + orderManner + ", orderMoney="
				+ orderMoney + ", orderStatus=" + orderStatus + ", imageUrl=" + imageUrl + "]";
	}


}
