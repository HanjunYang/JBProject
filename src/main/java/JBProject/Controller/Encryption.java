package JBProject.Controller;


public interface Encryption {
        String encrypt(String pw);
        boolean isMatch(String plainPw,String hashedpw);
}
