package mandy.app;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TypeTest {
    @Test
    public void testBugIncrease() {
        List<Type> bugIncrease = Type.BUG.getIncrease();
        assertNotNull(bugIncrease);
        assertEquals(3, bugIncrease.size());
        assertEquals(Type.GRASS, bugIncrease.get(0));
        assertEquals(Type.PSYCHIC, bugIncrease.get(1));
        assertEquals(Type.DARK, bugIncrease.get(2));
    }

    @Test
    public void testBugDecrease() {
        List<Type> bugDecrease = Type.BUG.getDecrease();
        assertNotNull(bugDecrease);
        assertEquals(7, bugDecrease.size());
        assertEquals(Type.FIRE, bugDecrease.get(0));
        assertEquals(Type.FIGHTING, bugDecrease.get(1));
        assertEquals(Type.POISON, bugDecrease.get(2));
        assertEquals(Type.FLYING, bugDecrease.get(3));
        assertEquals(Type.GHOST, bugDecrease.get(4));
        assertEquals(Type.STEEL, bugDecrease.get(5));
        assertEquals(Type.FAIRY, bugDecrease.get(6));
    }

    @Test
    public void testBugImmune() {
        List<Type> bugImmune = Type.BUG.getImmune();
        assertEquals(0, bugImmune.size());
    }
}