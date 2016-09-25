package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Rulebook;

import java.util.List;
import java.util.Map;

public interface RulebookFactory {
    public Rulebook createRulebook(Map<String, List<List<Object>>> rulebookSpecification); //rulebookSpecification is a Map where the keys
    // are the String that identify a rule, and the value is a List, where each element of the List is another List of Objects, which are
    // the parameters for the Rule constructor. This constraint exists so that all rules can be created in the same fashion, and multiple
    // instances of a rule can be created with different parameters.
}
