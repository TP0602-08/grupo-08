package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.Rulebook;
import ar.fiuba.tdd.tp1.model.RulebookCatalog;
import ar.fiuba.tdd.tp1.serialization.interfaces.RulebookSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RulebookJsonSerializer implements RulebookSerializer {
    private List<RuleJson> rulesJson;
    private RulebookCatalog catalog;

    public RulebookJsonSerializer(List<RuleJson> rules, RulebookCatalog catalog) {
        this.rulesJson = rules.stream().filter(i -> i != null).collect(Collectors.toList());
        this.catalog = catalog;
    }

    public Rulebook deserialize() {
        Map<String, List<List<Object>>> rulebookSpecification = new HashMap<>();
        for (RuleJson rule : this.rulesJson) {
            List<Object> specifications = getRuleSpecifications(rule);
            if (rulebookSpecification.containsKey(rule.getType())) {
                rulebookSpecification.get(rule.getType()).add(specifications);
            } else {
                List<List<Object>> allRuleSpecifications = new ArrayList<>();
                allRuleSpecifications.add(specifications);
                rulebookSpecification.put(rule.getType(), allRuleSpecifications);
            }
        }

        return catalog.createRulebook(rulebookSpecification);
    }

    private List<Object> getRuleSpecifications(RuleJson rule) {
        List<Object> specifications = new ArrayList<>();
        if (rule.getRegion() != null) {
            specifications.add(rule.getRegion());
        }
        if (rule.getValue() != null) {
            specifications.add(rule.getValue());
        }
        return specifications;
    }
}
