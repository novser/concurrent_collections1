public class Operator extends Thread {

    private CallCenter callCenter;
    private final int timeout = 3000;
    private String name;

    public Operator(CallCenter callCenter, String name) {
        this.callCenter = callCenter;
        this.name = name;
    }

    @Override
    public void run() {
        while (callCenter.getCalls().poll() != null) {
            System.out.println(name + " обрабатывает звонок");
            try {
                Thread.sleep(timeout);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
