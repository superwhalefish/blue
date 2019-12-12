package com.yy.spring.entity;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="orders")
public class Orders {
	public Integer oid;// 订单id
	public String ordnumber;// 订单编号
	public Integer ocid;// 客户编号
	public String consignee;// 收货人
	public String oadress;// 收货地址
	public String otel;// 联系电话
	public String opaytatus;// 支付状态
	public String opayway;// 支付方式
	public String ofhstatus;// 发货状态
	public String ojsstatus;// 接收状态
	public String xordtime;// 下单时间
	public String fordtime;// 发货时间
	public String jsordtime;// 签收时间
	public Integer orderinfoid;//订单详情id
	public String pjstatus;
	//搜索条件
	public String xordtimeStart;
	public String xordtimeEnd;
	public String fordtimeStart;
	public String fordtimeEnd;
	public String jsordtimeStart;
	public String jsordtimeEnd;
   //商品
	public Product product;
	//商品分类
	public ProductCategroy productCategroy;
	//订单
	public OrderInfo orderInfo;
	//图片
	public ProductImg productimg;
	


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Orders(Integer oid, String ordnumber, Integer ocid, String consignee, String oadress, String otel,
			String opaytatus, String opayway, String ofhstatus, String ojsstatus, String xordtime, String fordtime,
			String jsordtime, Integer orderinfoid, String pjstatus, String xordtimeStart, String xordtimeEnd,
			String fordtimeStart, String fordtimeEnd, String jsordtimeStart, String jsordtimeEnd, Product product,
			ProductCategroy productcategroy, OrderInfo orderInfo, ProductImg productimg) {
		super();
		this.oid = oid;
		this.ordnumber = ordnumber;
		this.ocid = ocid;
		this.consignee = consignee;
		this.oadress = oadress;
		this.otel = otel;
		this.opaytatus = opaytatus;
		this.opayway = opayway;
		this.ofhstatus = ofhstatus;
		this.ojsstatus = ojsstatus;
		this.xordtime = xordtime;
		this.fordtime = fordtime;
		this.jsordtime = jsordtime;
		this.orderinfoid = orderinfoid;
		this.pjstatus = pjstatus;
		this.xordtimeStart = xordtimeStart;
		this.xordtimeEnd = xordtimeEnd;
		this.fordtimeStart = fordtimeStart;
		this.fordtimeEnd = fordtimeEnd;
		this.jsordtimeStart = jsordtimeStart;
		this.jsordtimeEnd = jsordtimeEnd;
		this.product = product;
		this.productCategroy = productcategroy;
		this.orderInfo = orderInfo;
		this.productimg = productimg;
	}




	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOrdnumber() {
		return ordnumber;
	}

	public void setOrdnumber(String ordnumber) {
		this.ordnumber = ordnumber;
	}

	public Integer getOcid() {
		return ocid;
	}

	public void setOcid(Integer ocid) {
		this.ocid = ocid;
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

	public String getOpaytatus() {
		return opaytatus;
	}

	public void setOpaytatus(String opaytatus) {
		this.opaytatus = opaytatus;
	}

	public String getOpayway() {
		return opayway;
	}

	public void setOpayway(String opayway) {
		this.opayway = opayway;
	}

	public String getOfhstatus() {
		return ofhstatus;
	}

	public void setOfhstatus(String ofhstatus) {
		this.ofhstatus = ofhstatus;
	}

	public String getOjsstatus() {
		return ojsstatus;
	}

	public void setOjsstatus(String ojsstatus) {
		this.ojsstatus = ojsstatus;
	}

	public String getXordtime() {
		return xordtime;
	}

	public void setXordtime(String xordtime) {
		this.xordtime = xordtime;
	}

	public String getFordtime() {
		return fordtime;
	}

	public void setFordtime(String fordtime) {
		this.fordtime = fordtime;
	}

	public String getJsordtime() {
		return jsordtime;
	}

	public void setJsordtime(String jsordtime) {
		this.jsordtime = jsordtime;
	}

	public String getXordtimeStart() {
		return xordtimeStart;
	}
	public void setXordtimeStart(String xordtimeStart) {
		this.xordtimeStart = xordtimeStart;
	}
	public String getXordtimeEnd() {
		return xordtimeEnd;
	}
	public void setXordtimeEnd(String xordtimeEnd) {
		this.xordtimeEnd = xordtimeEnd;
	}
   
	public String getFordtimeStart() {
		return fordtimeStart;
	}
	public void setFordtimeStart(String fordtimeStart) {
		this.fordtimeStart = fordtimeStart;
	}
	public String getFordtimeEnd() {
		return fordtimeEnd;
	}
	public void setFordtimeEnd(String fordtimeEnd) {
		this.fordtimeEnd = fordtimeEnd;
	}
	public String getJsordtimeStart() {
		return jsordtimeStart;
	}
	public void setJsordtimeStart(String jsordtimeStart) {
		this.jsordtimeStart = jsordtimeStart;
	}
	public String getJsordtimeEnd() {
		return jsordtimeEnd;
	}
	public void setJsordtimeEnd(String jsordtimeEnd) {
		this.jsordtimeEnd = jsordtimeEnd;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductCategroy getProductcategroy() {
		return productCategroy;
	}

	public void setProductcategroy(ProductCategroy productCategroy) {
		this.productCategroy = productCategroy;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	
	public Integer getOrderinfoid() {
		return orderinfoid;
	}

	public void setOrderinfoid(Integer orderinfoid) {
		this.orderinfoid = orderinfoid;
	}

	public String getPjstatus() {
		return pjstatus;
	}


	public void setPjstatus(String pjstatus) {
		this.pjstatus = pjstatus;
	}


	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordnumber=" + ordnumber + ", ocid=" + ocid + ", consignee=" + consignee
				+ ", oadress=" + oadress + ", otel=" + otel + ", opaytatus=" + opaytatus + ", opayway=" + opayway
				+ ", ofhstatus=" + ofhstatus + ", ojsstatus=" + ojsstatus + ", xordtime=" + xordtime + ", fordtime="
				+ fordtime + ", jsordtime=" + jsordtime + ", orderinfoid=" + orderinfoid + ", pjstatus=" + pjstatus
				+ ", xordtimeStart=" + xordtimeStart + ", xordtimeEnd=" + xordtimeEnd + ", fordtimeStart="
				+ fordtimeStart + ", fordtimeEnd=" + fordtimeEnd + ", jsordtimeStart=" + jsordtimeStart
				+ ", jsordtimeEnd=" + jsordtimeEnd + ", product=" + product + ", productcategroy=" + productCategroy
				+ ", orderInfo=" + orderInfo +  ", productimg=" + productimg + "]";
	}
}
