package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ch.netem.mapper.ProductMapper;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Product;
import cn.ch.netem.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

	@Override
	public List<Product> selectAll(int page,int pageNum) {
		return productMapper.selectAll(page, pageNum);
	}

	@Override
	public Product selectByPrimaryKey(Integer productId) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(productId);
	}

	public int deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return productMapper.deleteProduct(productId);
	}

	

	@Override
	public List<Product> selectAll2(Page page, String productName) {
		Integer userCount = productMapper.countProduct(productName);
		page.setItemCount(userCount);
		return productMapper.selectAll2(page, productName);
	}

	@Override
	public int countProduct(String productName) {
		// TODO Auto-generated method stub
		return productMapper.countProduct(productName);
	}

    
}
