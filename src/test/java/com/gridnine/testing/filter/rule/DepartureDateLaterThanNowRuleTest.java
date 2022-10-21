package com.gridnine.testing.filter.rule;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.builder.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.*;

class DepartureDateLaterThanNowRuleTest {
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    Flight flight = createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow);

    @Test
    void checkDepartureDateLaterThanNowRule_Test() {
        DepartureDateLaterThanNowRule rule = new DepartureDateLaterThanNowRule();
        boolean actual = rule.check(flight);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}