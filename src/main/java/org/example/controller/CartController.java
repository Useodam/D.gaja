package org.example.controller;

import org.example.domain.CartDto;
import org.example.domain.CartOptDto;
import org.example.domain.OrderDto;
import org.example.domain.ProdDto;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;


    @GetMapping("/list")
    public String getCart(Model m, HttpServletRequest request) {
        try {
            if(!loginCheck(request)) {
                return "redirect:/login/login?toURL="+request.getRequestURL();      // 로그인을 안했으면 로그인 화면으로 이동
            }

            HttpSession session = request.getSession();
            String custId = (String)session.getAttribute("id");          // 로그인 한 아이디 가져오기

            List<CartDto> cartList = cartService.getCartList(custId);          // 로그인한 아이디에 담긴 장바구니 목록을 리스트로 담는다
            m.addAttribute("cartList", cartList);                  // list를 모델에 담는다.

            List<List<CartOptDto>> optLists = cartService.getAllOptList(custId);

//            for (List<CartOptDto> optList: optLists) {
//                m.addAttribute("optList", optList);
//            }
            m.addAttribute("optLists", optLists);

            OrderDto orddto = cartService.getOrdHist(custId);             // 장바구니 내용을 하나로 합쳐서 주문에 넣기 위해 OrderDto 형식으로 요약해놓은것
            m.addAttribute("ord",orddto);                     // orddto를 모델에 담는다.

//             session.invalidate(); //비로그인 장바구니 진입시 로그아웃으로 뜨는 에러 해결책 1번
            return"cart";
        } catch (Exception e) {
            return"error";
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseEntity<CartDto> addCart(@RequestBody List<CartOptDto> list, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String custId = " ";

            custId = (String)session.getAttribute("id");

            cartService.addCart(custId, list);

            return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @PatchMapping("/modify")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CartOptDto> minusCart(@RequestBody CartOptDto dto, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String custId = (String)session.getAttribute("id");

            cartService.modifyQty(dto.getOptQty(), custId, dto.getProdCd(), dto.getOptCd());

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<OrderDto> removeOpt(@RequestBody CartOptDto cartOptDto, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String custId = (String)session.getAttribute("id"); // id 받아오기

            cartService.removeOpt(custId, cartOptDto.getProdCd(), cartOptDto.getOptCd());

            OrderDto ordDto = cartService.getOrdHist(custId);
            return new ResponseEntity<>(ordDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeChecks")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> removeProd(@RequestBody Map<String, List<String>> requestBody, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String custId = (String)session.getAttribute("id"); // id 받아오기

            List<String> prodCds = requestBody.get("prodCds");
            System.out.println("prodCds = " + prodCds);
            cartService.removeProd(custId, prodCds);

            OrderDto ordDto = cartService.getOrdHist(custId);
            return new ResponseEntity<>(ordDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeAll")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<OrderDto> removeAll(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String custId = (String)session.getAttribute("id"); // id 받아오기

            cartService.removeAll(custId);

            OrderDto ordDto = cartService.getOrdHist(custId);

            return new ResponseEntity<>(ordDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id") != null;
    }
}