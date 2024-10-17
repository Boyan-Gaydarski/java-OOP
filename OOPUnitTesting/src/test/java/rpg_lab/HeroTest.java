package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroGainsXpByKillingTargets() {

        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Test_Hero", weapon);

        Target target = Mockito.mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(10);

        hero.attack(target);

        assertEquals(10, hero.getExperience());
    }

}