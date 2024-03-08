package springbasic.web.repository;

import jakarta.persistence.EntityManager;
import springbasic.web.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    /**
     * DataSource나 EntityManager은 spring-boot-starter-data-jpa 디펜던시 추가 시 스프링에서 들고 있음
     * 그러므로 의존성을 따로 주입해줄 필요없음.
     * @param em
     */
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(String id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",
                        Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
