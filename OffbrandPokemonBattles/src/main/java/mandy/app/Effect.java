package mandy.app;

public enum Effect {
    // sever poison doesn't exist here but poison will be "stackable" unlike other effects
    // this should replicate the effects of severe poison to some degree
    // let's see if i can get away with merging regular and special attack/defense
    // screw messing with accuracy and evasion because the different stat tables are too much for me
    BURN, FREEZE, PARALYSIS, POISON, SLEEP, CONFUSION,
    //TODO add flinching, Penny's Umbreon's Dark Pulse move is missing its flinch effect
    ATKBUFF, ATKDB, DEFBUFF, DEFDB, SPEEDBUFF, SPEEDDB
}
