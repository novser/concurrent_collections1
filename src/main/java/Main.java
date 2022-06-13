public class Main {

    private static final int callCenterTimeout = 5000;
    private static final int operatorCount = 3;
    private static Operator[] operators = new Operator[operatorCount];

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenter = new CallCenter(callCenterTimeout);
        callCenter.start();

        for (int i = 0; i < operatorCount; i++) {
            Operator operator = new Operator(callCenter, "Оператор " + (i + 1));
            operators[i] = operator;
            operator.start();
        }

        callCenter.join();
        for (Operator op : operators) {
            op.join();
        }

        System.out.println("Все звонки обработаны");

    }
}
