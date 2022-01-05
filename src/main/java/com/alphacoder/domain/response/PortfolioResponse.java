package com.alphacoder.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortfolioResponse {
    private Long id;
    private Double assetValue;
    private Date date;
    private Double cumulativeReturn;
}
