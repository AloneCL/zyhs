package zhumeng.zyhs.ssm.pojo;

public class User {
    private Integer id;
    private String userTel;           
    private String userName;           
    private String userPass;
    private String payPass; 
    private String imageUrl;
    private Double longitude;                   //用户定位的经度
    private Double latitude;                   //用户定位的纬度
    private String province;                   //所在的省份、市、县或区及街道
    private String city;
    private String area;
    private String recoverArea;              //买家负责回收的区域
    private String street;
    private String address;
    private Integer identity;               //用户身份标识
    private String ip;                     //用来微信小程序中的用户标识
    private Integer integral;              // 用户积分
    private Double balance;                // 用户余额
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getRecoverArea() {
		return recoverArea;
	}

	public void setRecoverArea(String recoverArea) {
		this.recoverArea = recoverArea;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userTel=" + userTel + ", userName=" + userName + ", userPass=" + userPass
				+ ", payPass=" + payPass + ", imageUrl=" + imageUrl + ", longitude=" + longitude + ", latitude="
				+ latitude + ", province=" + province + ", city=" + city + ", area=" + area + ", recoverArea="
				+ recoverArea + ", street=" + street + ", address=" + address + ", identity=" + identity + ", ip=" + ip
				+ ", integral=" + integral + ", balance=" + balance + "]";
	}


}
