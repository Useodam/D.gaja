package org.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CateMainDaoImplTest {

    @Autowired
    CateMainDao cateMainDao;
    @Test
    public void getCateCd() throws Exception {
        System.out.println(cateMainDao.getCateCd());
    }
    @Test
    public void selectAll() throws Exception {
        System.out.println("cateMain = " + cateMainDao.selectAll());
    }
}