import com.alibaba.testable.core.annotation.MockMethod;
import junit.framework.TestCase;
import org.junit.Test;

public class MockTest extends TestCase {

    private Mock mock = new Mock();

    @Test
    public void testHandle(){
        System.out.println(mock.handle(1));
    }

    @MockMethod(targetMethod="excce")
    public String excce(Covent self,String a){
        return "hello";
    }
}