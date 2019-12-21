package keywordframework;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest1 {
    @Parameters({ "suite-param" })
    @Test
    public void prameterTest1(String param) {
        System.out.println("Test one suite parameter is: " + param);
    }
 
    @Parameters({ "paramtest2" })
    @Test
    public void prameterTest2(String param) {
        System.out.println("Test two parameter is: " + param);
    }
 
    @Parameters({ "suite-param", "paramtest3" })
    @Test
    public void prameterTest3(String param, String param2) {
        System.out.println("Test three suite parameter is: " + param);
        System.out.println("Test three parameter is: " + param2);
    }
}