public class exceptionTest {
    public static void main(String[] args) {
        float x = 0;
        try {
            System.out.println("start try");
            x = 1/0;
            System.out.println("end try");

        } catch (Exception e) {
            System.out.println("cath : 1/0");
        }finally {
            System.out.println(" finally");
        }

        System.out.println("end");
    }
}
