public class BigElevator extends Elevator {

    public BigElevator(CurrentCountPeople peoples) {
        super(peoples);
        capacity = 10;
        periodInSeconds = 2;
    }

    @Override
    public void showResultsLiftPeople(int countOfPeople) {
        System.out.println("большой лифт поднял " + countOfPeople + " человек");
    }

    @Override
    public void showTotal() {
        System.out.println("большой лифт поднял всего " + peopleCounting + " человек");
    }
}
