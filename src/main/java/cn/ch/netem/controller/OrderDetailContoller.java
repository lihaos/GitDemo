package cn.ch.netem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ch.netem.pojo.OrderDetail;
import cn.ch.netem.service.OrderDetailService;

@Controller
public class OrderDetailContoller {
		@Autowired
		private OrderDetailService orderDetailService;
		private List<OrderDetail> list=null;
		
		/*//插入订单详情
		@RequestMapping("/Order")
		String insert(@RequestParam("orderId")int orderId,@RequestParam("productId")int productId,
				@RequestParam("quantity")int quantity,@RequestParam("price")Double price,Model model){
			list =new ArrayList<OrderDetail>();
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(1);
			orderDetail.setProductId(productId);
			orderDetail.setQuantity(quantity);
			orderDetail.setCost(price*quantity);
			orderDetailService.insertSelective(orderDetail);
			list.add(orderDetail);
			model.addAttribute("list",list);
			return "/pre/productList";
		}*/
}
