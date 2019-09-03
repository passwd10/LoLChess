package Common;

public class TimeThread implements Runnable {

    int time;
    public TimeThread(int time) {
        this.time = time;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(time * 1000); //30초
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 시간초과");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
                        " 라운드 종료 " +
                        "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                Thread.interrupted();

            } catch (Exception e) {

            }

    }

}
