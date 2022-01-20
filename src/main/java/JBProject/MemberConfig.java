package JBProject;

import JBProject.Repository.JPAMemberRepository;
import JBProject.Repository.MemberRepository;
import JBProject.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;


@Configuration
public class MemberConfig {

    private EntityManager em;

    public MemberConfig(EntityManager em){
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        return new JPAMemberRepository(em);
    }


}
