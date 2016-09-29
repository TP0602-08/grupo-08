package ar.fiuba.tdd.tp1.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegionTest {
    @Test
    public void regionIsCreatedWithOneParameterConstructor() {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        Region region = new Region(list);
        assertTrue(list == region.getCellNamesList());
    }

    @Test
    public void regionIsCreatedWithTwoParameterConstructor() {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        String parameter = "ABC";
        Region region = new Region(list, parameter);
        assertTrue(list == region.getCellNamesList());
        assertTrue(parameter == region.getParam());
    }

    @Test
    public void getCellNamesList() {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        Region region = new Region(list);
        assertTrue(list == region.getCellNamesList());
    }

    @Test
    public void getParameter() {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        String parameter = "ABC";
        Region region = new Region(list, parameter);
        assertTrue(parameter == region.getParam());
    }

    @Test
    public void setParameter() {
        List<String> list = new ArrayList<String>();
        list.add("ABC");
        list.add("DEF");
        list.add("GHI");
        String parameter = "ABC";
        String newParameter = "DEF";
        Region region = new Region(list, parameter);
        region.setParam(newParameter);
        assertTrue(newParameter == region.getParam());
    }

}