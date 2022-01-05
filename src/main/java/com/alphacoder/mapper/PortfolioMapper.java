package com.alphacoder.mapper;

import com.alphacoder.domain.request.PortfolioRequest;
import com.alphacoder.domain.response.PortfolioResponse;
import com.alphacoder.entity.Portfolio;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PortfolioMapper {
    public PortfolioResponse mapPortfolioEntityToPortfolioResponse(Portfolio portfolioEntity);
    public Portfolio mapPortfolioRequestToPortfolioEntity(PortfolioRequest portfolioRequest);
}
