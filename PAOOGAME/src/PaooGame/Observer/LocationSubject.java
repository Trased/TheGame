package PaooGame.Observer;

public interface LocationSubject {
    public void registerObserver(PlayerLocationObserver obs);
    public void removeObserver(PlayerLocationObserver obs);

}
