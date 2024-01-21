//package springbasic.basic.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//import springbasic.basic.domain.Member;
//import springbasic.basic.repository.MemberRepository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@Slf4j
//@SpringBootTest
//@Transactional
//class MemberServiceIntegrationTest {
//
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Commit // Transactional로 롤백되지 않고 커밋함
//    public void 회원가입() throws Exception {
//        //Given
//        Member member = new Member();
//        member.setName("spring");
//
//        //When
//        Long saveId = memberService.join(member);
//
//        //Then
//        Member findMember = memberRepository.findById(saveId).get();
//        assertEquals(member.getName(), findMember.getName());
//    }
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        //Given
//        Member member1 = new Member();
//        member1.setName("spring");
//        Member member2 = new Member();
//        member2.setName("spring");
//        //When
//        memberService.join(member1);
//
//        IllegalStateException e = assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2));//예외가 발생해야 한다.
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//}