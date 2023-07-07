package org.example.dao;

import org.example.domain.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderDaoImplTest {
    @Autowired
    OrderDao orderDao;
    @Test
    public void selectTest() throws Exception {
        Map map = new HashMap();
        map.put("ordCd", "ord_01");
        map.put("custId", "asdf");

        System.out.println(orderDao.select(map));
    }

    @Test
    public void selectByMonthTest() throws Exception {
        Map map = new HashMap();
        map.put("custId", "asdf12");    // asdf12 아이디로
        map.put("i", 3);                // 3개월 이내에 주문한 내역

        System.out.println(orderDao.selectByMonth(map));
    }

    @Test
    public void selectByDateTest() throws Exception {
        Map map = new HashMap();
        map.put("custId", "asdf");          // 회원 asdf의
        map.put("startDate", "2023-06-01"); // 23년 6월 1일부터
        map.put("endDate", "2023-07-01");   // 23년 7월 1일까지의 주문내역

        System.out.println(orderDao.selectByDate(map));
    }

    @Test
    public void countTest() throws Exception {
        System.out.println(orderDao.count("asdf"));
    }

    @Test
    public void insertTest() throws Exception {
        OrderDto dto = new OrderDto("order_30","asdfasdf","상품1",1,1,1,"1","드가자~");
        orderDao.insert(dto);

        Map map = new HashMap();
        map.put("ordCd", "order_30");
        map.put("custId", "asdfasdf");
        System.out.println(orderDao.select(map));
    }

    @Test
    public void updOrdStatusTest() throws Exception {
        OrderDto dto = new OrderDto("Y", "order_30", "asdfasdf");
        orderDao.updOrdStatus(dto);

        Map map = new HashMap();
        map.put("ordCd", "order_30");
        map.put("custId", "asdfasdf");
        System.out.println(orderDao.select(map));
    }
}