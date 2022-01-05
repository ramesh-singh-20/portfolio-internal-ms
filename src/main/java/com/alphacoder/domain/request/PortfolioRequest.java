package com.alphacoder.domain.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortfolioRequest {
    private Long id;
    @NotNull(message = "Asset value cannot be empty.")
    private Double assetValue;

    @NotNull(message = "Date cannot be empty.")
    private Date date;

    private Double cumulativeReturn;
}
