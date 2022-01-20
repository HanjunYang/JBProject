package JBProject.Domain;

import javax.persistence.*;

@Entity
//@SequenceGenerator(name = "User_Seq",sequenceName = "sequence",initialValue = 1)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pkId;
    @Column
    private String memberId;
    @Column
    private String memberPw;
    @Column
    private String memberName;
    @Column
    private String memberPhone;




    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getPkId() {
        return pkId;
    }
}
