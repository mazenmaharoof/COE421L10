package Lab10_ex1;

import java.util.Random;

public class Friend implements Observer {
    private final String name;
    private final UI ui;
    private final Random rand = new Random();

    public Friend(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.registerObserver(this);
    }

    @Override
    public void update(int energy) {

        if (rand.nextBoolean()) {
            ui.print(name + ": Eren, please be safe!");
        }

        if (energy < 20) {
            ui.print(name + ": Rage, rage against the dying of the light");
        }
    }
}
