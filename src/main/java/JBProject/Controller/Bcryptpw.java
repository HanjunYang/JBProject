package JBProject.Controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class Bcryptpw implements Encryption {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Bcryptpw(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encrypt(String password) {
        int saltRounds = 10;
        String encoded_pw = this.passwordEncoder.encode(password);
        return BCrypt.hashpw(encoded_pw,BCrypt.gensalt(saltRounds));
    }

    @Override
    public boolean isMatch(String plainPw, String hashedPw) {

//        if(plainPw)
        return BCrypt.checkpw(plainPw, hashedPw);
    }

//    암호화된 것과 원문의 매칭
//    private void checkPass(String plainPassword, String hasedPassword) {
//        if (BCrypt.checkpw(plainPassword, hasedPassword)) {
//        // doSomething();
//        }
//    }


}
