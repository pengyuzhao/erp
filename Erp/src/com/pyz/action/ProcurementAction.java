package com.pyz.action;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;




import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import com.pyz.domain.Depot;
import com.pyz.domain.Goods;
import com.pyz.domain.OrderForm;

import com.pyz.domain.OrderItem;
import com.pyz.domain.Provider;
import com.pyz.service.inter.CustomerServiceInter;
import com.pyz.service.inter.DepotServiceInter;
import com.pyz.service.inter.GoodsServiceInter;
import com.pyz.service.inter.OrderFormServiceInter;
import com.pyz.service.inter.OrderItemServiceInter;
import com.pyz.service.inter.ProviderServiceInter;
import com.pyz.service.inter.TypeServiceInter;

@Controller
@Scope("prototype")
public class ProcurementAction {

	private List result;
	private int goodsId;
	private int depotId;
	private int providerId;
	private int page;
	private int row;
	private String ids ;
	private OrderForm orderForm;
	private OrderItem orderItem;
	private int orderformId;
	@Resource
	private TypeServiceInter typeServiceImp;
	@Resource
	private ProviderServiceInter providerServiceImp;
	@Resource
	private DepotServiceInter depotServiceImp;
	@Resource
	private OrderFormServiceInter orderFormServiceImp;
	@Resource
	private GoodsServiceInter goodsServiceImp;
	@Resource 
	private OrderItemServiceInter orderItemServiceImp;
	@Resource
	private CustomerServiceInter customerServiceImp;
	public DepotServiceInter getDepotServiceImp() {
		return depotServiceImp;
	}

	public void setDepotServiceImp(DepotServiceInter depotServiceImp) {
		this.depotServiceImp = depotServiceImp;
	}
	
	public OrderFormServiceInter getOrderFormServiceImp() {
		return orderFormServiceImp;
	}

	public void setOrderFormServiceImp(OrderFormServiceInter orderFormServiceImp) {
		this.orderFormServiceImp = orderFormServiceImp;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public ProviderServiceInter getProviderServiceImp() {
		return providerServiceImp;
	}

	public void setProviderServiceImp(ProviderServiceInter providerServiceImp) {
		this.providerServiceImp = providerServiceImp;
	}
	
	public GoodsServiceInter getGoodsServiceImp() {
		return goodsServiceImp;
	}

	public void setGoodsServiceImp(GoodsServiceInter goodsServiceImp) {
		this.goodsServiceImp = goodsServiceImp;
	}
	
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	
	public int getDepotId() {
		return depotId;
	}

	public void setDepotId(int depotId) {
		this.depotId = depotId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	
	public int getOrderformId() {
		return orderformId;
	}

	public void setOrderformId(int orderformId) {
		this.orderformId = orderformId;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public OrderItemServiceInter getOrderItemServiceImp() {
		return orderItemServiceImp;
	}

	public void setOrderItemServiceImp(OrderItemServiceInter orderItemServiceImp) {
		this.orderItemServiceImp = orderItemServiceImp;
	}
	
	public TypeServiceInter getTypeServiceImp() {
		return typeServiceImp;
	}

	public void setTypeServiceImp(TypeServiceInter typeServiceImp) {
		this.typeServiceImp = typeServiceImp;
	}
	
	public CustomerServiceInter getCustomerServiceImp() {
		return customerServiceImp;
	}

	public void setCustomerServiceImp(CustomerServiceInter customerServiceImp) {
		this.customerServiceImp = customerServiceImp;
	}

	// 得到供应商
	public String getProvider() {
		
		List<Provider> list = providerServiceImp.getProvider();
		result = list;
		return "success";
	}

	// 得到仓库
	public String getDepot() {
		List<Depot> list = depotServiceImp.getDepot();
		result=list;
		return "success";
	}
	//得到票号
	public String getOrderfromId(){
		List list = orderFormServiceImp.getOrderFormId();
		result = list ;
		return "success";
	}
	//得到商品
	public String getGoods(){
	
		List list = goodsServiceImp.getGoods(providerId);
		result = list ; 
		return "success";
	}
	//根据id得到商品其他信息
	public String getGoodsInfo(){
	
		List list = goodsServiceImp.getGoodsInfo(goodsId);
		result = list ; 
		return "success";
	}
	//得到订单
	public String getOrderForms(){

			List list =	orderFormServiceImp.getOrderForm();
			result =list;
			return "success";
	}
	//查询订单
	public String queryOrderForm(){
		
		
			List list = orderItemServiceImp.getOrderItem(orderformId);
			result = list ; 	
			return "success";
	}
	//生成订单
	public String addOrderForm(){
		
			orderForm.setOrderDate(new Date());
			orderForm.setState("等待");
			int id = Integer.parseInt(goodsServiceImp.add(orderForm).toString());
			List list = new ArrayList();
			list.add(id);
			result = list;
			return "success";
	}
	//删除订单
		public String delOrderForms(){
			
			
				orderFormServiceImp.delOrderForm(ids);
			
				
				return "success";
		}
	//修改订单
		public String updateOrderForms(){
			
			
			OrderForm o= (OrderForm) orderFormServiceImp.findById(OrderForm.class,orderForm.getId());
			o.setState(orderForm.getState());
			orderFormServiceImp.update(o);
			return "success";
		}
	//生成子订单
	public String addOrderFormItem(){
		
			Depot d=(Depot) orderFormServiceImp.findById(Depot.class, depotId+"");
			Goods g=(Goods) orderFormServiceImp.findById(Goods.class, goodsId+"");
			OrderForm o=(OrderForm) orderFormServiceImp.findById(OrderForm.class, orderformId+"");
			orderItem.setOrderform(o);
			orderItem.setGoods(g);
			orderItem.setDepot(d);
			String id =	orderFormServiceImp.add(orderItem).toString();
			List list = new ArrayList();
			list.add(id);
			result = list ;
			return "success";
	}
	//删除子订单
	public String delOrderItems(){
	
		orderItemServiceImp.delOrderItem(ids);
		return "success";
	}
	//加载子订单
	public String getOrderItems(){
		
		
		return "success";
	}
	//得到类型
		public String getType(){
			
			List list = typeServiceImp.getTypes();
			result = list; 
			return "success";
		}
		//得到类型
		public String getCustomer(){
					
		List list = customerServiceImp.getCustomer();
		result = list; 
		return "success";
		}
	
}
