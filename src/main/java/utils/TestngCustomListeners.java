package utils;
import org.testng.IExecutionListener;
public class TestngCustomListeners implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.err.println("TestNG is commencing execution");
    }

    @Override
    public void onExecutionFinish() {
        System.err.println("TestNG has finished execution");
    }
}
