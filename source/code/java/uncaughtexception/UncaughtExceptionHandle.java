public class UncaughtExceptionHandle {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> log.error("Uncaught exception: ", e));
    }
}