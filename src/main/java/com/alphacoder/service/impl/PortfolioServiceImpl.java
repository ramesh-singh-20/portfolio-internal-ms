package com.alphacoder.service.impl;

import com.alphacoder.domain.error.ErrorDto;
import com.alphacoder.domain.request.PortfolioRequest;
import com.alphacoder.domain.response.PortfolioResponse;
import com.alphacoder.entity.Portfolio;
import com.alphacoder.exception.ApplicationDomainException;
import com.alphacoder.mapper.PortfolioMapper;
import com.alphacoder.repository.PortfolioRepository;
import com.alphacoder.service.PortfolioService;
import com.alphacoder.util.PortfolioUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
@Slf4j
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    @Override
    public List<PortfolioResponse> getPortfolioDetails() {
        List<PortfolioResponse> response= null;
        List<Portfolio> portfolioEntityList= this.portfolioRepository.findAllByOrderByDateAsc();
        if(null!= portfolioEntityList && !portfolioEntityList.isEmpty()){
            response= new ArrayList<>();
            for(Portfolio entity: portfolioEntityList){
                response.add(portfolioMapper.mapPortfolioEntityToPortfolioResponse(entity));
            }
        }
        return response;
    }

    @Override
    public Double getLatestPortfolioValue() {
        Optional<Double> portfolioDoubleOptional= this.portfolioRepository.findLatestAssetValue();
        if(portfolioDoubleOptional.isPresent()){
            return portfolioDoubleOptional.get();
        }else{
            List<ErrorDto> errors = PortfolioUtil.getErrorDtos("Portfolio_1001",
                    "No data found. Please try again.");
            throw new ApplicationDomainException(errors, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void add(PortfolioRequest request) {
        log.info("Portfolio Request: "+request);
        Portfolio portfolio= portfolioMapper.mapPortfolioRequestToPortfolioEntity(request);

        log.info("Portfolio Entity After Mapping: "+ portfolio);

        portfolioRepository.save(portfolio);
    }

    @Override
    public void update(PortfolioRequest request) {
        log.info("Portfolio request: "+request);
        Portfolio portfolio= portfolioMapper.mapPortfolioRequestToPortfolioEntity(request);
        log.info("Portfolio Entity After Mapping: "+ portfolio);
        portfolioRepository.save(portfolio);
    }

    @Override
    public void delete(Long id) {
        log.info("Portfolio id: "+id);
        portfolioRepository.deleteById(id);
    }
}
