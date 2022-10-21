package com.gridnine.testing.filter.rule;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.gridnine.testing.builder.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.*;

class ArrivalDateEarlyLaterDepartureDateRuleTest {
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    Flight flight = createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6));

    @Test
    void checkArrivalDateEarlyLaterDepartureDateRule_Test() {
        ArrivalDateEarlyLaterDepartureDateRule rule = new ArrivalDateEarlyLaterDepartureDateRule();
        boolean actual = rule.check(flight);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}