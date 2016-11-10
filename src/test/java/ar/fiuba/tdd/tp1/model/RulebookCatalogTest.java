package ar.fiuba.tdd.tp1.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RulebookCatalogTest {
    @Test
    public void rulebookCatalogIsCreated() {
        Map<String, Rule> map = new HashMap<String, Rule>();
        Board board = new Board(5, 5);
        Rule rule1 = new RuleNoRepeatedValues(board);
        Rule rule2 = new RuleTotalSumEquals(board);
        map.put(rule1.getName(), rule1);
        map.put(rule2.getName(), rule2);
        RulebookCatalog rulebookCatalog = new RulebookCatalog(map);
        assertTrue(map == rulebookCatalog.getRulesCatalog());
    }

    @Test
    public void add() {
        Map<String, Rule> map = new HashMap<String, Rule>();
        Board board = new Board(5, 5);
        Rule rule1 = new RuleNoRepeatedValues(board);
        Rule rule2 = new RuleTotalSumEquals(board);
        map.put(rule1.getName(), rule1);
        RulebookCatalog rulebookCatalog = new RulebookCatalog(map);
        assertFalse(rulebookCatalog.getRulesCatalog().containsKey(rule2.getName()));
        rulebookCatalog.add(rule2.getName(), rule2);
        assertTrue(rulebookCatalog.getRulesCatalog().containsKey(rule2.getName()));
    }

    public Map<String, Rule> createMap(Board board, Rule rule1, Rule rule2) {
        Map<String, Rule> map = new HashMap<String, Rule>();
        map.put(rule1.getName(), rule1);
        map.put(rule2.getName(), rule2);
        return map;
    }

    public List<List<Object>> createList1() {
        List<Object> parametersList1 = new ArrayList<Object>();
        parametersList1.add("Region1");
        List<List<Object>> listOfParameterListsForRule1 = new ArrayList<List<Object>>();
        listOfParameterListsForRule1.add(parametersList1);
        return listOfParameterListsForRule1;
    }

    public List<List<Object>> createList2() {
        List<Object> parametersList2 = new ArrayList<Object>();
        parametersList2.add("Region2");
        parametersList2.add(new Integer(2));
        List<Object> parametersList3 = new ArrayList<Object>();
        parametersList3.add("Region3");
        parametersList3.add(new Integer(3));
        List<Object> parametersList4 = new ArrayList<Object>();
        parametersList4.add("Region4");
        parametersList4.add(new Integer(4));
        List<List<Object>> listOfParameterListsForRule2 = new ArrayList<List<Object>>();
        listOfParameterListsForRule2.add(parametersList2);
        listOfParameterListsForRule2.add(parametersList3);
        listOfParameterListsForRule2.add(parametersList4);
        return listOfParameterListsForRule2;
    }

    public int countStuff(List<Rule> rulesList, Rule rule1) {
        int counter = 0;
        for (Rule ruleIterator : rulesList) {
            if (ruleIterator.getName().equals(rule1.getName())) {
                counter++;
            }
        }
        return counter;
    }

    @Test
    public void createRulebook() {
        Board board = new Board(5, 5);
        Rule rule1 = new RuleNoRepeatedValues(board);
        Rule rule2 = new RuleTotalSumEquals(board);
        Map<String, Rule> map = createMap(board, rule1, rule2);

        List<List<Object>> listOfParameterListsForRule1 = createList1();
        List<List<Object>> listOfParameterListsForRule2 = createList2();

        Map<String, List<List<Object>>> rulebookSpecification = new HashMap<String, List<List<Object>>>();
        rulebookSpecification.put(rule1.getName(), listOfParameterListsForRule1);
        rulebookSpecification.put(rule2.getName(), listOfParameterListsForRule2);
        RulebookCatalog rulebookCatalog = new RulebookCatalog(map);
        Rulebook rulebook = rulebookCatalog.createRulebook(rulebookSpecification);

        List<Rule> rulesList = rulebook.getRulesList();

        assertTrue(rulesList.size() == 4);

        int counter = countStuff(rulesList, rule1);
        assertEquals(counter, 1);
        counter = countStuff(rulesList, rule2);
        assertEquals(counter, 3);
    }
}