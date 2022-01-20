package JBProject.Controller;



public interface Encryption {
        String encrypt(String plainpassword);
        boolean isMatch(String plainPw,String hashedpw);
}
