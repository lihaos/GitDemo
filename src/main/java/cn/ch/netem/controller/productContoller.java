package cn.ch.netem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Product;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.ProductService;
@Controller
public class productContoller {
	@Autowired
	private ProductService productService;
	//前端查看产品
	@RequestMapping("/demoTest")
	public String test1(@RequestParam(required=false,defaultValue="1",value="page")int page,
			@RequestParam(value="productName",required=false)String productName,Model  model) {
		int pageNum=2;
		page=(page-1)*pageNum;
		int num = productService.countProduct(productName);//获取到总条数
		int zong = num%2==0?num/2:num/2+1;//获取到总页数
		List<Product> list=  productService.selectAll(page, pageNum);
		model.addAttribute("productList", list);
		model.addAttribute("page", page);
		model.addAttribute("zong", zong);
    	return "/pre/productList";
    }
	
	
	
	//后端查看产品
		@RequestMapping("/selectProducts")
		@ResponseBody
		public Map test2(@RequestParam(required=false,defaultValue="1",value="page")int page,
				@RequestParam(value="productName",required=false)String productName,Model  model) {
			/*int pageNum=2;
			page=(page-1)*pageNum;
			List<Product> list=  productService.selectAll2(page,productName,pageNum);
			int num = productService.countProduct();//获取到总条数
			int zong = num%2==0?num/2:num/2+1;//获取到总页数
			Map map = new HashMap();
			map.put("productList", list);
			model.addAttribute("page", page);
			model.addAttribute("zong", zong);
	    	*/
			Page pages = new Page();
			pages.setCurrentPage(page);
			List<Product> findProductAll = productService.selectAll2(pages, productName);
			Map map = new HashMap();
			map.put("users", findProductAll);
			map.put("page", page);
			return map;
	    }
		
		
	/**
	  * 查看单个产品详细信息
     * **/
	@ResponseBody
	@RequestMapping("/demo1")
	Product selectByPrimaryKey(@RequestParam("productId")Integer productId,HttpServletResponse response) {
		Product product = new Product();
		product = productService.selectByPrimaryKey(productId);
		return product;
	 }
	
	/**
	 * 删除商品
	 * */
	@RequestMapping("/deleteShan")
	int deleteProducts(@RequestParam("productId")Integer productId) {
		int num = productService.deleteProduct(productId);
		return num;
	}
	/**
	 * 插入商品 文件上传
	 **/
	/*@RequestMapping(value="/upload",method=RequestMethod.POST)  
	    @ResponseBody  
	    public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();    
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        file.transferTo(dir);  
	        return "ok!";  
	    }  */
}
