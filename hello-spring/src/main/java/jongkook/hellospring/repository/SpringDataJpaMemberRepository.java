package jongkook.hellospring.repository;

import jongkook.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberReopository {

    @Override
    Optional<Member> findByName(String name);
}
