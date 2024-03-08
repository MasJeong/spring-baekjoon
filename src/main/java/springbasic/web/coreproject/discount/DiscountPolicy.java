package springbasic.web.coreproject.discount;

import springbasic.web.domain.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
