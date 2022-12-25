public abstract class Elevator implements Runnable {
    public int capacity;
    public int periodInSeconds;
    public int peopleCounting;
    private CurrentCountPeople peoplesRest;

    public Elevator(CurrentCountPeople currentCountPeople) {
        peoplesRest = currentCountPeople;
    }

    private boolean liftPeople() {
        boolean sucsessLift = false;
        int countOfPeople = peoplesRest.decrimentPeoplesRest(capacity);
        if (countOfPeople > 0) {
            try {
                Thread.sleep(periodInSeconds * 1000);
                peopleCounting += countOfPeople;
                showResultsLiftPeople(countOfPeople);
                sucsessLift = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return sucsessLift;
    }

    @Override
    public void run() {
        while (liftPeople()) {
        }
    }

    public void endLift() {
        if (peopleCounting > 0) {
            showTotal();
            peopleCounting = 0;
        }
    }

    public abstract void showResultsLiftPeople(int countOfPeople);

    public abstract void showTotal();
}
