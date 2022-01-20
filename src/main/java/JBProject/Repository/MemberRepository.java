package JBProject.Repository;
import JBProject.Domain.Member;
import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByMemberId(String memberId);
    Optional<Member> findByName(String memberName);
    Optional<Member> findByPhone(String memberPhone);
    Optional<Member> LoginInfo(String memberId);
    List<Member> findByAll();

}
