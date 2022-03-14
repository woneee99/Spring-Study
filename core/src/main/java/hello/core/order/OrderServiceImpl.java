package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPoilcy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPoilcy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
/* DIP 위반 : DiscountPolicy뿐만 아니라 FixDiscountPoilcy인 구체 클래스도 함께 의존
  OCP 위반 : FixDiscountPoilcy를 RateDiscountPolicy로 고치는 순간 OrderServiceImpl 소스코드도 함께 변경해야함
*/

    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
