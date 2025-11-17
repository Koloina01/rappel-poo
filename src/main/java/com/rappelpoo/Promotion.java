package com.rappelpoo;

import java.util.Set;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Setter
@AllArgsConstructor
public class Promotion {
    private String name;
    private Set<String> groups;
}
