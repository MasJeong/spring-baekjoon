package springbasic.web.service;

import org.springframework.transaction.annotation.Transactional;
import springbasic.web.domain.Member;
import springbasic.web.enums.Grade;
import springbasic.web.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public String join(Member member) {
        //중복 회원 검증
        validateDuplicateMember(member);

        // ID 컬럼에 @GeneratedValue 사용하고 값 세팅 후 persist 호출 시 jpa가 detached 상태의 객체로 인식함.
        // detached 객체를 다시 영속화 하려면 merge를 사용해야 함.
//        member.setMemberId("");

        member.setGrade(Grade.BASIC);
        Member saveMember = memberRepository.save(member);

        return member.getId();
    }

    /**
     * 중복 회원을 검증한다.
     * @param member 회원 객체
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }
}
