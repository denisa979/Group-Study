package com.group.pojos.prices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group.pojos.prices.data.PricesData;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Prices {

    @JsonProperty("data")
    private PricesData data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;
}
