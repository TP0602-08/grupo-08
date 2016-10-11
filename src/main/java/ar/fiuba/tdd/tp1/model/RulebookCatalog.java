package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.RulebookFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RulebookCatalog implements RulebookFactory {
    private Map<String, Rule> rulesCatalog;

    //Constructor that receives a map with all the key-value pairs that are the name of the rule and an instance of the specific rule
    // created with the constructor that only takes the Board as parameter.
    public RulebookCatalog(Map<String, Rule> rulesMapValue) {
        this.rulesCatalog = rulesMapValue;
    }

    public RulebookCatalog(Board board) {
        this.rulesCatalog = new HashMap<String, Rule>();
        add("RuleNoRepeatedValues", new RuleNoRepeatedValues(board));
        add("RuleTotalSumEquals", new RuleTotalSumEquals(board));
        add("RuleTotalProductEquals", new RuleTotalProductEquals(board));
    }

    public void add(String name, Rule rule) {
        rulesCatalog.put(name, rule);
    }

    public Map<String, Rule> getRulesCatalog() {
        return this.rulesCatalog;
    }

    //For each key (String which is a Rule's name) in the rulebookSpecification Map, search for the value with matching key in the
    // rulesCatalog Map, and create a new Rule, passing the List<Object> as parameters, to the rule creator method, as many times as
    // elements there are in the outer List (if there are 20 List<Object> in List<List<Object>>, then make 20 new instances of that rule,
    // one for each list of parameters (List<Object>)).
    @Override
    public Rulebook createRulebook(Map<String, List<List<Object>>> rulebookSpecification) {
        List<Rule> rulesList = new ArrayList<Rule>();
        for (Map.Entry<String, List<List<Object>>> entry : rulebookSpecification.entrySet()) {
            for (List<Object> parameterList : rulebookSpecification.get(entry.getKey())) {
                Rule rule = rulesCatalog.get(entry.getKey()).createNewInstance(parameterList);
                rulesList.add(rule);
            }
        }
        Rulebook rulebook = new Rulebook(rulesList);
        return rulebook;
    }
}
