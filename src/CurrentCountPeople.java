public class CurrentCountPeople {

    public synchronized void setCount(int count) {
        this.peoplesRest = count;
    }

    public synchronized int decrimentPeoplesRest (int capacity){
        int minPeople = Math.min(peoplesRest,capacity);
        peoplesRest -= minPeople;
        return minPeople;
    }
    private int peoplesRest =0;
}
