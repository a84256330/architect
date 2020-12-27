import javax.annotation.Resource;

public class IMockServiceImpl implements IMockService{


    @Override
    public String handle(int var) {
        IMockService2 iMockService2 = new IMockService2Impl();
        return iMockService2.handle2(2);
    }
}
