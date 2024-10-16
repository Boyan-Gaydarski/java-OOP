package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testDummyLoosesHealthAfterAttack() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(1);

        assertEquals(9, dummy.getHealth());
    }

    @Test
    public void testDummyCanDieAfterAttack() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(10);

        assertTrue(dummy.isDead());
    }

    @Test(expected = IllegalStateException.class)
    public void testCannotAttackDeadDummy() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(10);

        dummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyGivesXP() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(10);

        assertTrue(dummy.giveExperience() != 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesNotGiveXP() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(5);

        assertTrue(dummy.giveExperience() == 0);
    }
}