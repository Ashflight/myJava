package mandy.app;

public enum Effect {
    // sever poison doesn't exist here but poison will be "stackable" unlike other effects
    // this should replicate the effects of severe poison to some degree
    // let's see if i can get away with merging regular and special attack/defense
    // screw messing with accuracy and evasion because the different stat tables are too much for me
    BURN, FREEZE, PARALYSIS, POISON, SLEEP, CONFUSION,
    //TODO add flinching, Penny's Umbreon's Dark Pulse move is missing its flinch effect
    ATKBUFF, ATKDB, DEFBUFF, DEFDB, SPEEDBUFF, SPEEDDB
    //TODO think about barriers, just implementing them as defense vs as a separate thing
    // Arven's Greedent's Psychic Fangs move is currently missing the barrier removal function
    // Arven's Greedent's Earthquake move is currently missing the does 2x damage to pokemon underground via Dig condition
    // Nemona's Lycanroc's Stealth Rock move currently does nothing because I haven't incorporated entry hazards into my design
}
