package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;
import ar.fiuba.tdd.tp1.model.interfaces.RulebookFactory;

import java.util.List;
import java.util.Map;

public class RulebookCatalog implements RulebookFactory {
    private Map<String, Rule> rulesCatalog;

    //Constructor that receives a map with all the key-value pairs that are the name of the rule and an instance of the specific rule
    // created with the constructor that only takes the Board as parameter.
    public RulebookCatalog(Map<String, Rule> rulesMapValue) {
        //TODO(Ivan) Ver si está bien "pasarle" los objetos así, o si necesita hacer copias de las listas, mapas y sus elementos.
        this.rulesCatalog = rulesMapValue;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    void add(String name, Rule rule) {
        rulesCatalog.put(name, rule);
    }

    @Override
    public Rulebook createRulebook(Map<String, List<List<Object>>> rulebookSpecification) {
        //TODO(Ivan) For each key (String which is a Rule's name) in the rulebookSpecification Map, search for the value with matching
        // key in the rulesCatalog Map, and create a new Rule, passing the List<Object> as parameters, to the rule creator method, as
        // many times as elements there are in the outer List (if there are 20 List<Object> in List<List<Object>>, then make 20 new
        // rules, one for each List<Object>).
        return null;
    }
}
