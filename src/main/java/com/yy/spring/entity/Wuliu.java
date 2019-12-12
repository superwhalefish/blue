package com.yy.spring.entity;


import org.springframework.stereotype.Component;

@Component
public class Wuliu {
	public Integer wid;//物流id
	public String wname;//物流公司名
	public String ordnumber;//订单编号
	public String consignee;//收货人
	public String oadress;//收货地址
	public String otel;//联系电话
	public String fordtime;//发货时间
	public String pname;//商品名
	public String cpname;//商品分类
	public String wuliudanhao;//物流单号
	public Wuliu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wuliu(Integer wid, String wname, String ordnumber, String consignee, String oadress, String otel,
			String fordtime, String pname, String cpname, String wuliudanhao) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.ordnumber = ordnumber;
		this.consignee = consignee;
		this.oadress = oadress;
		this.otel = otel;
		this.fordtime = fordtime;
		this.pname = pname;
		this.cpname = cpname;
		this.wuliudanhao = wuliudanhao;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getOrdnumber() {
		return ordnumber;
	}
	public void setOrdnumber(String ordnumber) {
		this.ordnumber = ordnumber;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getOadress() {
		return oadress;
	}
	public void setOadress(String oadress) {
		this.oadress = oadress;
	}
	public String getOtel() {
		return otel;
	}
	public void setOtel(String otel) {
		this.otel = otel;
	}
	public String getFordtime() {
		return fordtime;
	}
	public void setFordtime(String fordtime) {
		this.fordtime = fordtime;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public String getWuliudanhao() {
		return wuliudanhao;
	}
	public void setWuliudanhao(String wuliudanhao) {
		this.wuliudanhao = wuliudanhao;
	}
	@Override
	public String toString() {
		return "Wuliu [wid=" + wid + ", wname=" + wname + ", ordnumber=" + ordnumber + ", consignee=" + consignee
				+ ", oadress=" + oadress + ", otel=" + otel + ", fordtime=" + fordtime + ", pname=" + pname
				+ ", cpname=" + cpname + ", wuliudanhao=" + wuliudanhao + "]";
	}
	
}
