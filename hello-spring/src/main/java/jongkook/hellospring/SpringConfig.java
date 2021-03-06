package jongkook.hellospring;


import jongkook.hellospring.aop.TimeTraceAop;
import jongkook.hellospring.repository.JdbcTemplateMemberRepository;
import jongkook.hellospring.repository.JpaMemberRepository;
import jongkook.hellospring.repository.MemberReopository;
import jongkook.hellospring.repository.MemoryMemberRepository;
import jongkook.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberReopository memberRepository;

    public SpringConfig(MemberReopository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberReopository memberRepository() {
////         return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
