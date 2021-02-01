package jongkook.hellospring.repository;

import jongkook.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberReopository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
