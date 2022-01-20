package JBProject.Controller;

import JBProject.Domain.Member;
import JBProject.Repository.JPAMemberRepository;
import JBProject.Service.MemberService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final Bcryptpw bcryptpw;
    private final JPAMemberRepository jpaMemberRepository;

    @Autowired
    public MemberController(MemberService memberService, Bcryptpw bcryptpw, JPAMemberRepository jpaMemberRepository) {
        this.memberService = memberService;
        this.bcryptpw = bcryptpw;
        this.jpaMemberRepository = jpaMemberRepository;
    }

    @GetMapping("/joinMember")
    public String joinMember() {
        return "joinmember";
    }

    @PostMapping("/joinMember")
    public String createId(Memberform memberform) {
        //비밀번호 해쉬화
        String hashedPw = this.bcryptpw.encrypt(memberform.getMemberPw1());
        memberform.setMemberPw1(hashedPw);
        Member member = new Member();
        member.setMemberId(memberform.getMemberId());
        member.setMemberPw(memberform.getMemberPw1());
        member.setMemberName(memberform.getMemberName());
        member.setMemberPhone(memberform.getMemberPhone());
        this.memberService.saveId(member);

        return "joinmember";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String logincheck(@RequestParam(name = "loginId") String loginId,
                             @RequestParam(name = "loginPw") String loginPw) {

        Object matchingPw = jpaMemberRepository.LoginInfo(loginId);
        BCrypt bCrypt = new BCrypt();
        if (BCrypt.checkpw(loginPw, (String) matchingPw)) {
            return "loginload";
        }else {
            return "loginfail";
        }

    }
}