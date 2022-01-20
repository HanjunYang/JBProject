package JBProject.Controller;
import JBProject.Domain.Member;
import JBProject.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

        @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/joinMember")
    public String joinMember(){
        return "joinmember";
    }

    @PostMapping("/joinMember")
    public String createId(Memberform memberform){
        //비밀번호 해쉬화
        Bycryptpw bycryptpw = new Bycryptpw();
        String hashedPw = bycryptpw.encrypt(memberform.getMemberPw1());
        memberform.setMemberPw1(hashedPw);
          System.out.println("000000000000000000000000000");
        Member member = new Member();
        member.setMemberId(memberform.getMemberId());
        member.setMemberPw(memberform.getMemberPw1());
        member.setMemberName(memberform.getMemberName());
        member.setMemberPhone(memberform.getMemberPhone());
        System.out.println("1111111111111111111111 ");
        this.memberService.saveId(member);
        System.out.println("222222222222222222222222");

        return "joinmember";
    }

}
