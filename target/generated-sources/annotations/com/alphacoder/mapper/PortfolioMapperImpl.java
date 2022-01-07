package com.alphacoder.mapper;

import com.alphacoder.domain.request.PortfolioRequest;
import com.alphacoder.domain.response.PortfolioResponse;
import com.alphacoder.entity.Portfolio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-05T15:57:06-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class PortfolioMapperImpl implements PortfolioMapper {

    @Override
    public PortfolioResponse mapPortfolioEntityToPortfolioResponse(Portfolio portfolioEntity) {
        if ( portfolioEntity == null ) {
            return null;
        }

        PortfolioResponse portfolioResponse = new PortfolioResponse();

        portfolioResponse.setId( portfolioEntity.getId() );
        portfolioResponse.setAssetValue( portfolioEntity.getAssetValue() );
        portfolioResponse.setDate( portfolioEntity.getDate() );
        portfolioResponse.setCumulativeReturn( portfolioEntity.getCumulativeReturn() );

        return portfolioResponse;
    }

    @Override
    public Portfolio mapPortfolioRequestToPortfolioEntity(PortfolioRequest portfolioRequest) {
        if ( portfolioRequest == null ) {
            return null;
        }

        Portfolio portfolio = new Portfolio();

        portfolio.setId( portfolioRequest.getId() );
        portfolio.setAssetValue( portfolioRequest.getAssetValue() );
        portfolio.setDate( portfolioRequest.getDate() );
        portfolio.setCumulativeReturn( portfolioRequest.getCumulativeReturn() );

        return portfolio;
    }
}
