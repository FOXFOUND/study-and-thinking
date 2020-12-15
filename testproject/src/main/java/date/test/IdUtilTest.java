package date.test;

public class IdUtilTest {
    /**
     * id除年月前缀后的id长度
     */
    public static final int ID_NONY_LENGTH = 8;
    public static void main(String[] args) {
        String newString = String.format("%0"+ID_NONY_LENGTH+"d", 1);
        System.out.println(newString);
    }
}
