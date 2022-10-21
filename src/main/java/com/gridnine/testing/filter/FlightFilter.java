package com.gridnine.testing.filter;

import com.gridnine.testing.filter.rule.FlightFilterRule;
import com.gridnine.testing.model.Flight;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlightFilter {
    private final List<FlightFilterRule> rules;

    public FlightFilter(List<FlightFilterRule> rules) {
        this.rules = rules;
    }

    public void filteredFlight(List<Flight> flights) {

        Map<String, List<Flight>> flightMap = filter(flights);
        StringBuilder stringBuilder = new StringBuilder();
        List<Flight> result = new LinkedList<>();

        for (Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(", ");
            if (result.isEmpty()) {
                result.addAll(entry.getValue());
            } else {
                result.retainAll(entry.getValue());
            }
        }
        System.out.println(stringBuilder);
        result.forEach(System.out::println);
    }


    private Map<String, List<Flight>> filter(List<Flight> flights) {
        final Map<String, List<Flight>> resultMap = new HashMap<>();
        rules.forEach(rule ->
                resultMap.put(
                        rule.getMessage(),
                        flights.stream()
                                .filter(rule::check)
                                .toList()
                )
        );
        return resultMap;
    }
}
