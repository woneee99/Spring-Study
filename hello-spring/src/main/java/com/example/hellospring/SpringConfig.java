package com.example.hellospring;

import com.example.hellospring.Aop.TimeTraceAop;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

/*
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
*//*
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*
    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);

    }
*/

}
