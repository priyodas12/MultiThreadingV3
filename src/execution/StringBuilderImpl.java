package execution;

import java.util.UUID;

public class StringBuilderImpl {

    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder("abc-").append(UUID.randomUUID());
        System.out.println(stringBuilder);
    }
}
