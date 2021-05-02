package com.jing.dumplingcloud;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Domain Object
 */
@Data
public class Dumpling {

    @NotNull
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotNull(message="You must choose at least 1 ingredient")
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

}
