package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void testHeroGainsXpByKillingTargets() {

        Target target = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 10;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon weapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero("Test_Hero", weapon);

        hero.attack(target);

        assertEquals(10, hero.getExperience());
    }

}