public class CurrentCountPeople {

    private int peoplesRest = 0;

    public synchronized void setCount(int count) {
        this.peoplesRest = count;
    }

    public synchronized int decrimentPeoplesRest(int capacity) {
        int minPeople = Math.min(peoplesRest, capacity);
        peoplesRest -= minPeople;
        return minPeople;
    }

}
