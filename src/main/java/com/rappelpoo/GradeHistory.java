package com.rappelpoo;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GradeHistory {
    private Instant startDate;
    private double newValue;
    private String reason;
}
