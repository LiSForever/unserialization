import org.example.test.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class TestUser {
    public static void main(String[] args) throws IOException {
        User user = new User("Bob");
        user.setParent(new User("Josua"));
        ByteArrayOutputStream byteSteam = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteSteam);
        oos.writeObject(user);
        System.out.println(Base64.getEncoder().encodeToString(byteSteam.toByteArray()));

    }

}
