package patterns.behavioural.template.game;

public class Exercise {
    class Creature {
        public int attack, health;

        public Creature(int attack, int health) {
            this.attack = attack;
            this.health = health;
        }
    }

    abstract class CardGame {
        public Creature[] creatures;

        public CardGame(Creature[] creatures) {
            this.creatures = creatures;
        }

        // returns -1 if no clear winner (both alive or both dead)
        public int combat(int creature1, int creature2) {
            Creature first = creatures[creature1];
            Creature second = creatures[creature2];
            hit(first, second);
            hit(second, first);
            // todo: determine who won and return either creature1 or creature2
            boolean bothDead = (first.health == 0 && second.health == 0) || (first.health > 0 && second.health > 0);
            if (bothDead) {
                return -1;
            }

            if (first.health < 0) {
                return 2;
            }

            return 1;
        }

        // attacker hits other creature
        protected abstract void hit(Creature attacker, Creature other);
    }

    class TemporaryCardDamageGame extends CardGame {
        // todo
        public TemporaryCardDamageGame(Creature[] creatures) {
            super(creatures);
        }

        @Override
        public void hit(Creature attacker, Creature other) {
            // only apply the damage if it kills other
            if (attacker.attack >= other.health) {
                other.health = 0;
            }
        }
    }

    class PermanentCardDamageGame extends CardGame {
        // todo
        public PermanentCardDamageGame(Creature[] creatures) {
            super(creatures);
        }

        @Override
        public void hit(Creature attacker, Creature other) {
            if (attacker.attack >= other.health) {
                other.health = 0;
            } else {
                other.health -= attacker.attack;
            }

        }
    }
}
