package patterns.behavioural.observer.Game;

import static org.junit.Assert.assertEquals;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Dungeon {
    static class Game
    {
        // todo
        Set<Rat> rats = new HashSet<>();

        public void addRat(Rat rat) {
            rats.add(rat);
            propagateChange();
        }

        private void propagateChange() {
            for (Rat r : rats) {
                if (r==null || r.isDeleted())
                    continue;
                r.setAttack(rats.size());
            }
        }
        public void removeRat(Rat rat) {
            rats.remove(rat);
            propagateChange();
        }
    }

    class Rat implements Closeable
    {
        private Game game;
        public int attack = 1;
        private boolean isDeleted = false;

        public Rat(Game game)
        {

            // todo: rat enters game here
            game.addRat(this);
        }

        public void setAttack(int atk) {
            attack = atk;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        @Override
        public void close() throws IOException
        {
            // todo: rat dies ;(
            isDeleted = true;
            game.removeRat(this);
        }



    }
    public void singleRatTest()
    {
        Game game = new Game();
        Rat rat = new Rat(game);
        assertEquals(1, rat.attack);
    }

    public void twoRatTest()
    {
        Game game = new Game();
        Rat rat = new Rat(game);
        Rat rat2 = new Rat(game);
        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);
    }

    public void threeRatsOneDies()
        throws IOException
    {
        Game game = new Game();

        Rat rat = new Rat(game);
        assertEquals(1, rat.attack);

        Rat rat2 = new Rat(game);
        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);

        try (Rat rat3 = new Rat(game))
        {
            assertEquals(3, rat.attack);
            assertEquals(3, rat2.attack);
            assertEquals(3, rat3.attack);
        }

        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);
    }
    public static void main(String[] args) throws IOException {
        Dungeon dungeon = new Dungeon();
        dungeon.singleRatTest();
        dungeon.twoRatTest();
        dungeon.threeRatsOneDies();

    }
}
