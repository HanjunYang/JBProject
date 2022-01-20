package JBProject.Controller;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.PersistenceUnit;


public class Bycryptpw implements Encryption {

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String plainPw, String hashedPw) {
        if(BCrypt.checkpw(plainPw,hashedPw)){

        }
        return false;
    }


//    private String hashPw(String plainTextPw){
//        return BCrypt.hashpw(plainTextPw,BCrypt.gensalt());
//    }

//    암호화된 것과 원문의 매칭
//    private void checkPass(String plainPassword, String hasedPassword) {
//        if (BCrypt.checkpw(plainPassword, hasedPassword)) {
//        // doSomething();
//        }
//    }


}
