package com.gridnine.testing;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.rule.ArrivalDateEarlyLaterDepartureDateRule;
import com.gridnine.testing.filter.rule.DepartureDateLaterThanNowRule;
import com.gridnine.testing.filter.rule.TimeBetweenFlightsLessThanSomeHoursRule;
import com.gridnine.testing.model.Flight;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Flight> listOfFlights = FlightBuilder.createFlights();
        System.out.println("Flights from test builder:");
        listOfFlights.forEach(System.out::println);
        System.out.println();

        FlightFilter flightFilter = new FlightFilter(
                List.of(
                        new DepartureDateLaterThanNowRule()
                )
        );
        flightFilter.filteredFlight(listOfFlights);
        System.out.println();

        FlightFilter flightFilterTwo = new FlightFilter(
                List.of(
                        new ArrivalDateEarlyLaterDepartureDateRule()
                )
        );
        flightFilterTwo.filteredFlight(listOfFlights);
        System.out.println();

        FlightFilter flightFilterThree = new FlightFilter(
                List.of(
                        new TimeBetweenFlightsLessThanSomeHoursRule(2)
                )
        );
        flightFilterThree.filteredFlight(listOfFlights);
        System.out.println();

        FlightFilter flightFilterAll = new FlightFilter(
                List.of(
                        new DepartureDateLaterThanNowRule(),
                        new ArrivalDateEarlyLaterDepartureDateRule(),
                        new TimeBetweenFlightsLessThanSomeHoursRule(2)
                )
        );
        flightFilterAll.filteredFlight(listOfFlights);
    }
}
