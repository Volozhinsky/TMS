public class FastElevator extends Elevator {

    public FastElevator(CurrentCountPeople peoples) {
        super(peoples);
        capacity = 6;
        periodInSeconds = 1;
    }

    @Override
    public void showResultsLiftPeople(int countOfPeople) {
        System.out.println("скоростной лифт поднял " + countOfPeople + " человек");
    }

    @Override
    public void showTotal() {
        System.out.println("скоростной лифт поднял всего " + peopleCounting + " человек");
    }
}
