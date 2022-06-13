import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter extends Thread {

    private final int frequency = 60;
    private final int delay = 1000;
    private final int timeout;
    private Queue<Call> calls;
    private int callsCount;

    public CallCenter(int timeout) {
        this.timeout = timeout;
        calls = new LinkedBlockingQueue();
    }

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < timeout) {
            try {
                for (int i = 0; i < frequency; i++) {
                    calls.offer(new Call());
                    callsCount++;
                }
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Поступило " + callsCount + " звонков");
    }

    public Queue<Call> getCalls() {
        return calls;
    }
}
