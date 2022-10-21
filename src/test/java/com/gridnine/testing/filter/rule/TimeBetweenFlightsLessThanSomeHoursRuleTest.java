package com.gridnine.testing.filter.rule;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.gridnine.testing.builder.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeBetweenFlightsLessThanSomeHoursRuleTest {
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    Flight flight = createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
            threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
            threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7));
    @Test
    void checkTimeBetweenFlightsLessThanSomeHoursRule_Test() {
        TimeBetweenFlightsLessThanSomeHoursRule rule = new TimeBetweenFlightsLessThanSomeHoursRule(2);
        boolean actual = rule.check(flight);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}