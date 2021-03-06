package JBProject.Repository;

import JBProject.Domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPAMemberRepository implements MemberRepository{

    private final EntityManager em;


    public JPAMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        List<Member> result = em.createQuery("select m from Member m where m.memberId =:memberId",Member.class)
                .setParameter("memberId",memberId)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String memberName) {
        List<Member> result = em.createQuery("select m from Member m where m.memberName = :memberName", Member.class)
                .setParameter("memberName",memberName)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPhone(String memberPhone) {
        List<Member> result = em.createQuery("select m from Member m where m.memberPhone = :memberPhone", Member.class)
                .setParameter("memberPhone",memberPhone)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<Member> LoginInfo(String memberId) {
         List<Member> result = em.createQuery("select m.memberPw from Member m where m.memberId = :memberId",Member.class)
                .setParameter("memberId", memberId)
                .getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Member> findByAll() {

        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
