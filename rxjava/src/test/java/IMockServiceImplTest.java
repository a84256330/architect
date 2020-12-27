import com.alibaba.testable.core.annotation.MockMethod;
import junit.framework.TestCase;
import org.junit.Test;

public class IMockServiceImplTest extends TestCase {

    IMockService iMockService = new IMockServiceImpl();
    @Test
    public void testHandle(){
        System.out.println(iMockService.handle(2));
    }

    @MockMethod(targetMethod="handle2")
    public String handle2(IMockService2 self,int var) {
        return "23";
    }
}