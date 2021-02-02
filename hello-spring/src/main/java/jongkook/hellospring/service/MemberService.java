package jongkook.hellospring.service;

import jongkook.hellospring.domain.Member;
import jongkook.hellospring.repository.MemberReopository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberReopository memberReopository;

    public MemberService(MemberReopository memberReopository) {
        this.memberReopository = memberReopository;
    }


    /**
     * Sign up
     */
    public Long join(Member member){

        //같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member); //중복회원검증

        memberReopository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberReopository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("There is other member with same name");
                 });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers(){
        return  memberReopository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberReopository.findById(memberId);
    }


}
