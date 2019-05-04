public class Main {

    public static void run(String[] args) {
        long startTime = System.currentTimeMillis();


        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        runtime /= 1000;
        System.out.println("\tRun time: " + runtime + " seconds");
    }
    
    public static void main(String[] args) {
        run(args);
    }
}