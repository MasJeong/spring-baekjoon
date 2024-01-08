package springbasic.basic.coreproject.service;

import springbasic.basic.coreproject.order.CheckOut;

public interface CheckOutService {

    /**
     * @return 주문 생성 Order 객체
     */
    CheckOut createOrder(String memberId, String itemName, int itemPrice);
}
