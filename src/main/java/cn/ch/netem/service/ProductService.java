package cn.ch.netem.service;

import java.util.List;

import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Product;

public interface ProductService {
	 /**
 	* 查看产品列表
 	* **/
	 List<Product> selectAll(int pag,int pagename);
	 
	 /**
	 * 查看产品列表
	 * **/
	 List<Product> selectAll2(Page pag,String productName);
		 
	 /**
	  * 查看单个产品详细详细
      * **/
	 Product selectByPrimaryKey(Integer productId);
	 /**
	  * 删除产品
      * **/
	 int deleteProduct(int productId);
	 /**
	  * 统计个数
      * **/
	 int countProduct(String productName);
	 /**
	  * 修改产品
      * **/
	 
	
}
