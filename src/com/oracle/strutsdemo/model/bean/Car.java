package com.oracle.strutsdemo.model.bean;

import java.io.Serializable;
import java.util.Set;

public class Car  implements Serializable{  
	public Car(int carId) {
		super();
		this.carId = carId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", pinpaiming=" + pinpaiming + ", xilie=" + xilie + ", shoujia=" + shoujia
				+ ", goumaishijian=" + goumaishijian + ", gonglishu=" + gonglishu + ", pailiang=" + pailiang
				+ ", qicheshoutu=" + qicheshoutu + ", miaoshu=" + miaoshu + ", zhuangtai=" + zhuangtai
				+ ", cheliangleixing=" + cheliangleixing + ", biansuxiang=" + biansuxiang + ", dijishou=" + dijishou
				+ ", shipin=" + shipin + ", ranliaoleixing=" + ranliaoleixing + ", imgs=" + imgs + ", shifoutuiguang="
				+ shifoutuiguang + "]";
	}
	private int   carId;
	private String  pinpaiming;
	private String xilie;
	private float  shoujia;
	private String goumaishijian;
	private float  gonglishu;
	private String pailiang;
	private String qicheshoutu;
	private String miaoshu;
	private int zhuangtai;
	private String cheliangleixing;
	private String biansuxiang;
	private int dijishou;
	private String shipin;
	private String ranliaoleixing;
	
	private  Set<CarImage>  imgs;
	public Car(int carId, String pinpaiming, String xilie, float shoujia, String goumaishijian, float gonglishu,
			String pailiang, String qicheshoutu, String miaoshu, int zhuangtai, String cheliangleixing,
			String biansuxiang, int dijishou, String shipin, String ranliaoleixing, Set<CarImage> imgs,
			int shifoutuiguang) {
		super();
		this.carId = carId;
		this.pinpaiming = pinpaiming;
		this.xilie = xilie;
		this.shoujia = shoujia;
		this.goumaishijian = goumaishijian;
		this.gonglishu = gonglishu;
		this.pailiang = pailiang;
		this.qicheshoutu = qicheshoutu;
		this.miaoshu = miaoshu;
		this.zhuangtai = zhuangtai;
		this.cheliangleixing = cheliangleixing;
		this.biansuxiang = biansuxiang;
		this.dijishou = dijishou;
		this.shipin = shipin;
		this.ranliaoleixing = ranliaoleixing;
		this.imgs = imgs;
		this.shifoutuiguang = shifoutuiguang;
	}
	public Set<CarImage> getImgs() {
		return imgs;
	}
	public void setImgs(Set<CarImage> imgs) {
		this.imgs = imgs;
	}
	public Car(int carId, String pinpaiming, String xilie, float shoujia, String goumaishijian, float gonglishu,
			String pailiang, String qicheshoutu, String miaoshu, int zhuangtai, String cheliangleixing,
			String biansuxiang, int dijishou, String shipin, String ranliaoleixing, int shifoutuiguang) {
		super();
		this.carId = carId;
		this.pinpaiming = pinpaiming;
		this.xilie = xilie;
		this.shoujia = shoujia;
		this.goumaishijian = goumaishijian;
		this.gonglishu = gonglishu;
		this.pailiang = pailiang;
		this.qicheshoutu = qicheshoutu;
		this.miaoshu = miaoshu;
		this.zhuangtai = zhuangtai;
		this.cheliangleixing = cheliangleixing;
		this.biansuxiang = biansuxiang;
		this.dijishou = dijishou;
		this.shipin = shipin;
		this.ranliaoleixing = ranliaoleixing;
		this.shifoutuiguang = shifoutuiguang;
	}
	public String getRanliaoleixing() {
		return ranliaoleixing;
	}
	public void setRanliaoleixing(String ranliaoleixing) {
		this.ranliaoleixing = ranliaoleixing;
	}
	private int shifoutuiguang;
	public Car(int carId, String pinpaiming, String xilie, float shoujia, String goumaishijian, float gonglishu,
			String pailiang, String qicheshoutu, String miaoshu, int zhuangtai, String cheliangleixing,
			String biansuxiang, int dijishou, String shipin, int shifoutuiguang) {
		super();
		this.carId = carId;
		this.pinpaiming = pinpaiming;
		this.xilie = xilie;
		this.shoujia = shoujia;
		this.goumaishijian = goumaishijian;
		this.gonglishu = gonglishu;
		this.pailiang = pailiang;
		this.qicheshoutu = qicheshoutu;
		this.miaoshu = miaoshu;
		this.zhuangtai = zhuangtai;
		this.cheliangleixing = cheliangleixing;
		this.biansuxiang = biansuxiang;
		this.dijishou = dijishou;
		this.shipin = shipin;
		this.shifoutuiguang = shifoutuiguang;
	}
	public String getCheliangleixing() {
		return cheliangleixing;
	}
	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}
	public String getBiansuxiang() {
		return biansuxiang;
	}
	public void setBiansuxiang(String biansuxiang) {
		this.biansuxiang = biansuxiang;
	}
	public int getDijishou() {
		return dijishou;
	}
	public void setDijishou(int dijishou) {
		this.dijishou = dijishou;
	}
	public String getShipin() {
		return shipin;
	}
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	public int getShifoutuiguang() {
		return shifoutuiguang;
	}
	public void setShifoutuiguang(int shifoutuiguang) {
		this.shifoutuiguang = shifoutuiguang;
	}
	public Car() {
		super();
	}
	public Car(int carId, String pinpaiming, String xilie, float shoujia, String goumaishijian, float gonglishu,
			String pailiang, String qicheshoutu, String miaoshu, int zhuangtai) {
		super();
		this.carId = carId;
		this.pinpaiming = pinpaiming;
		this.xilie = xilie;
		this.shoujia = shoujia;
		this.goumaishijian = goumaishijian;
		this.gonglishu = gonglishu;
		this.pailiang = pailiang;
		this.qicheshoutu = qicheshoutu;
		this.miaoshu = miaoshu;
		this.zhuangtai = zhuangtai;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getPinpaiming() {
		return pinpaiming;
	}
	public void setPinpaiming(String pinpaiming) {
		this.pinpaiming = pinpaiming;
	}
	public String getXilie() {
		return xilie;
	}
	public void setXilie(String xilie) {
		this.xilie = xilie;
	}
	public float getShoujia() {
		return shoujia;
	}
	public void setShoujia(float shoujia) {
		this.shoujia = shoujia;
	}
	public String getGoumaishijian() {
		return goumaishijian;
	}
	public void setGoumaishijian(String goumaishijian) {
		this.goumaishijian = goumaishijian;
	}
	public float getGonglishu() {
		return gonglishu;
	}
	public void setGonglishu(float gonglishu) {
		this.gonglishu = gonglishu;
	}
	public String getPailiang() {
		return pailiang;
	}
	public void setPailiang(String pailiang) {
		this.pailiang = pailiang;
	}
	public String getQicheshoutu() {
		return qicheshoutu;
	}
	public void setQicheshoutu(String qicheshoutu) {
		this.qicheshoutu = qicheshoutu;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public int getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}
