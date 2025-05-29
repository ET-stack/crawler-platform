
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

/**
 * @className: PasswordTest
 * @description: TODO 类描述
 * @date: 2025/5/29
 **/


public class PasswordTest {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "admin123"; // 你明文密码
        String encodedPassword = "$2a$10$Z5JkhZJVoL1mJ.3UgA4KHebIjmXcWxqH7FbZL7Z6UFtNzvYIElG0q"; // 数据库存的密码

        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("密码匹配结果：" + matches);

        String newPassword = passwordEncoder.encode("admin123");
        System.out.println("新密码"+newPassword);



        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String base64Key = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Base64格式的密钥：" + base64Key);

    }



}
