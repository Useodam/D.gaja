package org.example.dao;

import org.example.domain.OrderDto;

import java.util.List;
import java.util.Map;

public interface OrderListDao {
    OrderDto select(Map map) throws Exception;

    List<OrderDto> selectByMonth(Map map) throws Exception;

    List<OrderDto> selectByDate(Map map) throws Exception;

    int count(String custId) throws Exception;

    int insert(OrderDto dto) throws Exception;

    int updOrdStatus(OrderDto dto) throws Exception;
}
