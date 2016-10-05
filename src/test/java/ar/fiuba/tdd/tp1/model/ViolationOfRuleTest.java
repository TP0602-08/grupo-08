package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ViolationOfRuleTest {
    private  List<Integer> celdasId;
    private  ViolationOfRule rules;

    @Before
    public  void setup() {
        this.celdasId = new ArrayList<Integer>();
        this.celdasId.add(new Integer(2));
        this.celdasId.add(new Integer(81));
        this.celdasId.add(new Integer(-1));
        this.rules = new ViolationOfRule("La suma excede el valor",celdasId );
    }

    @Test
    public void getExplanationTest() throws Exception {
        assertEquals("La suma excede el valor", rules.getExplanation());

    }

    public void getConflictingCellsList()throws Exception {
        assertEquals(2,celdasId.get(0).intValue());
        assertEquals(81,celdasId.get(1).intValue());
        assertEquals(-1,celdasId.get(2).intValue());
    }

}