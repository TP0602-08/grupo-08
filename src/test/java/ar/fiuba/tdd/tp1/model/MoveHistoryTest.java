package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveHistoryTest {
    private MoveHistory moveHistory;
    private Move movement;
    private Boolean valido;

    @Before
    public void setUp() throws Exception {
        this.moveHistory = new MoveHistory(this.movement,true);
    }

   @Test
   public void getMove() throws Exception {
       assertEquals(movement,this.moveHistory.getMove());
   }

    @Test
    public void wasValid() throws Exception {
        assertEquals(true,moveHistory.wasValid());
    }

}