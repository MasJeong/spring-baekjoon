package springbasic.web.coreproject.service;

import springbasic.web.coreproject.discount.DiscountPolicy;
import springbasic.web.coreproject.discount.FixDiscountPolicy;
import springbasic.web.coreproject.order.CheckOut;
import springbasic.web.domain.Member;
import springbasic.web.repository.MemberRepository;

import java.util.Optional;

public class CheckOutServiceImpl implements CheckOutService {

    // 회원 repository
    private final MemberRepository memberRepository;

    // 할인 정책 interface
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // SpringDataJpa 의존성 주입
    public CheckOutServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public CheckOut createOrder(String memberId, String itemName, int itemPrice) {
        Optional<Member> member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member.get(), itemPrice);

        return new CheckOut(memberId, itemName, itemPrice, discountPrice);
    }
}
