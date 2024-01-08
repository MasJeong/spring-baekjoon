package springbasic.basic.coreproject.discount;

import springbasic.basic.domain.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
