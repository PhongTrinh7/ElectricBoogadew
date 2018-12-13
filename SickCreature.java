public class SickCreature extends CreatureDecorator {

    public SickCreature(Creature c) {
        super(c);
    }

    @Override
    public String getAilment() {
        return super.getAilment() + "Dysentery";
    }

}
