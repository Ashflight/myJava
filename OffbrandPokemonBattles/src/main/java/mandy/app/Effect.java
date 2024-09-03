package mandy.app;

public enum Effect {
    // i am not going through the additional complications of trying to add severe poison
    // let's see if i can get away with merging regular and special attack/defense
    // screw messing with accuracy and evasion because the different stat tables are too much for me
    BURN, FREEZE, PARALYSIS, POISON, SLEEP, CONFUSION, // yes i forgot to add confusion, but idk how to implement flinching
    ATKBUFF, ATKDB, DEFBUFF, DEFDB, SPEEDBUFF, SPEEDDB
}
