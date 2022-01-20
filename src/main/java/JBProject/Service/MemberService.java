package JBProject.Service;

import JBProject.Domain.Member;
import JBProject.Repository.MemberRepository;

import javax.transaction.Transactional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public String saveId(Member member){
//        this.validateDuplicateMember(member);
        memberRepository.save(member);
         return member.getMemberId();
    }

//    public void validateDuplicateMember(Member member) {
//        this.memberRepository.findByMemberId(member.getMemberId()).ifPresent(member1 -> {
//            throw new IllegalStateException("이미 중복된 아이디입니다.");
//        });
//    }




//    public lostFindId(){
//        Member member = new Member();
//        CheckInfo(member.getMemberName(), member.getMemeberPhone()){
//
//        }
//
//    }

//    public void CheckInfo(String name, String phone){
//        List resultList = em.createQuery("select m.memberName, m.memberPhone From Member m ")
//                .getResultList();
//
//       public boolean equals(name,phone)
//
//    }


}

