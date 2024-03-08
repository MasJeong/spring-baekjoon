package springbasic.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbasic.web.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String>, MemberRepository{

    // JPQL로 쿼리가 나감
    @Override
    Optional<Member> findByName(String name);
}
