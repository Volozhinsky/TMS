import java.util.Scanner;

public class ElevatorsHall {
    public CurrentCountPeople currentCountPeople;
    private BigElevator bigElevator;
    private FastElevator fastElevator;

    public ElevatorsHall() {
        currentCountPeople = new CurrentCountPeople();
        bigElevator = new BigElevator(currentCountPeople);
        fastElevator = new FastElevator(currentCountPeople);
    }

    public synchronized void startLifting(int peopleCount) {
        currentCountPeople.setCount(peopleCount);
        Thread bigElevatorThread = new Thread(bigElevator);
        Thread fastElevatorThread = new Thread(fastElevator);

        bigElevatorThread.start();
        fastElevatorThread.start();
// подождем пока все лифты доедут, чтобы вывести итоги и забрать следущие входные данные
        try {
            bigElevatorThread.join();
            fastElevatorThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fastElevator.endLift();
        bigElevator.endLift();
    }

    public void start() {
        int passengersCount = 0;
        do {
            passengersCount = getPassengersCount();
            if (passengersCount > 0) {
                startLifting(passengersCount);
            }
        } while (passengersCount > 0);
    }

    private static int getPassengersCount() {
        System.out.println("введите количество людей");
        Scanner scanner = new Scanner(System.in);
        String countStr;
        do {
            countStr = scanner.nextLine();
        } while (!countStr.matches("\\d+"));
        return Integer.parseInt(countStr);
    }
}
