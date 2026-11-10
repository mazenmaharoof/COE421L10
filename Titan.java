package Lab10_ex1;

import java.util.Random;

public class Titan implements Observer {
    private final String name;
    private final UI ui;
    private final Random rand = new Random();

    public Titan(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.registerObserver(this);
    }

    @Override
    public void update(int energy) {

        if (rand.nextBoolean()) {
            ui.print(name + " attacks Eren!");
        }

        if (energy > 40) {
            ui.print(name + ": Now we got problems, and I don't think we can solve 'em");
        }
    }
}
