package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Order;
import cn.ch.netem.pojo.OrderExample;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);
    int insert(Order record);

    /**
     * 插入订单
     * */
    int insertSelective(Order recowesdhrd);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
    /**
         * 修改订单状态
     * */
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}