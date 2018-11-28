package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.OrderDetail;
import cn.ch.netem.pojo.OrderDetailExample;
import cn.ch.netem.pojo.Product;

public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer orderDetailId);
    
    int insert(OrderDetail record);

    /**
     * 插入订单详情
     * **/
    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    
}