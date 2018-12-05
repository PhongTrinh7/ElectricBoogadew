import java.awt.*;

public abstract class CreatureDecorator implements GameObject {

    protected final Creature decCreature;

    public CreatureDecorator(Creature creature) {
        decCreature = creature;
    }

    @Override
    public void tick() {
        decCreature.tick();
    }

    @Override
    public void render(Graphics g) {
        decCreature.render(g);
    }

    public String getAilment() {
        return "You've contracted: ";
    }
}
