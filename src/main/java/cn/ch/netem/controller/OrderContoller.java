package cn.ch.netem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ch.netem.mapper.OrderMapper;
import cn.ch.netem.pojo.Order;
import cn.ch.netem.pojo.OrderDetail;
import cn.ch.netem.pojo.Product;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.OrderDetailService;
import cn.ch.netem.service.ProductService;

@Controller
public class OrderContoller {

	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderDetailService orderDetailService;
	private List<Product> listProduct = new ArrayList<Product>();
	private List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
	private double costAll=0;
	//private User user=(User) SecurityUtils.getSubject().getPrincipal();//获取登录用户
	
	@RequestMapping("/dome123")
	String  selectProduct(@RequestParam(defaultValue="1")int userId,Model model) {
		/*List<Product>  list = orderMapper.getOrderDetail(userId);
		for (Product order : list) {
			System.out.println(order.getProductName());
		}*/
		model.addAttribute("list",listOrderDetail);
		return "/pre/wmTest";
	}
	int keys;
	Order order = new Order();
	//User user=(User) SecurityUtils.getSubject().getPrincipal();
	//插入订单号
	@ResponseBody
	@RequestMapping("/domeMai")
	int AddOrder(@RequestParam("quantity")int quantity,@RequestParam("productId")int productId,Model model){
		//下单时间  订单号 自己生成
		User user=(User) SecurityUtils.getSubject().getPrincipal();//获取登录用户
		//获取到下单的单个物品
		Product product = new Product();
		product = productService.selectByPrimaryKey(productId);
		product.setGeShu(quantity);
		
		if(costAll==0) {
			order.setUserId(user.getUserId());
			order.setUseraddress(user.getUserAddress());
			order.setCreatetime(new Date());//时间可能存在问题
			//order.setCost(cost);
			order.setSerialnumber(OrderContoller.getRandomString());
			order.setIsPay(0);
			orderMapper.insertSelective(order);
			keys=order.getOrderId();//获得插入之后的主键ID 主键回填
			System.out.println("==================>"+keys);
		}
		//获得总价格
		//costAll+=(((product.getPrice()*100)*(quantity*100))/10000);
		costAll+=product.getPrice()*quantity;
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(keys);
		orderDetail.setProductId(productId);
		orderDetail.setQuantity(quantity);
		orderDetail.setCost(product.getPrice()*quantity);
		product.setJiaGe(orderDetail.getCost());
		listProduct.add(product);//选择一个物品之后先添加到集合
		return orderDetailService.insertSelective(orderDetail);
		
	}
	
	//查看购物车
	@RequestMapping("/lookShop")
	String shoping(Model model) {
		model.addAttribute("listProduct",listProduct);
		model.addAttribute("costAll",costAll);
		return "/pre/shopings";
	}
	
	//支付之后插入订单的支付状态
	@ResponseBody
	@RequestMapping("/zhifu")
	int money(@RequestParam("cost")double cost) {
		Order order1 = new Order();
		order1.setCost(cost);
		order1.setIsPay(1);
		order1.setOrderId(order.getOrderId());
		int num = orderMapper.updateByPrimaryKeySelective(order1);
		
		if(num>0) {
			listProduct.clear();
			order = new Order();
			costAll=0;
		}
		return num;
	}
	//生成随机订单号
	public static  String getRandomString(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<8;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
