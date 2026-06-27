import java.io.*;

public class AttackObject implements Serializable {

    private String data = "attacker";

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {

        in.defaultReadObject();

        System.out.println(
            "[!] MALICIOUS CODE EXECUTED");
    }
}