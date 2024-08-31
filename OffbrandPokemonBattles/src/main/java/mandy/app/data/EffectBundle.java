package mandy.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandy.app.Effect;

public class EffectBundle {

    private Effect effect;
    private int chance;

    @JsonCreator
    public EffectBundle(@JsonProperty("effect") Effect effect, @JsonProperty("chance") int chance) {
        this.effect = effect;
        this.chance = chance;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getChance() {
        return chance;
    }
}
