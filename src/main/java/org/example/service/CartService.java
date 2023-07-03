package org.example.service;

import org.example.domain.CartDto;

import java.util.List;

public interface CartService {
    List<CartDto> getCartList(String custId) throws Exception;

    int remove(String custId, String prodCd) throws Exception;

    int removeAll(String custId) throws Exception;

    int increaseQty(String custId, String prodCd) throws Exception;

    int decreaseQty(String custId, String prodCd) throws Exception;
}
