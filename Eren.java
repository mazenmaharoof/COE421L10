package Lab10_ex1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Eren implements Runnable, Subject {
    private int energy;
    private final UI ui;
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final Random rand = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;

        new Thread(this).start();
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(energy);
        }
    }

    @Override
    public void run() {
        try {
            while (energy > 0) {

                Thread.sleep((5 + rand.nextInt(6)) * 1000);


                energy -= 5;
                ui.print("\n*** Eren transforms into a Titan! (energy = " + energy + ") ***");
                notifyObservers();


                Thread.sleep(10 * 1000);
                ui.print("*** Eren returns to human form ***");
            }
            ui.print("\nEren has run out of energy and cannot transform anymore.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

