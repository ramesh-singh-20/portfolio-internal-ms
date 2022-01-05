package com.alphacoder.service;

import com.alphacoder.domain.request.PortfolioRequest;
import com.alphacoder.domain.response.PortfolioResponse;

import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    public List<PortfolioResponse> getPortfolioDetails();
    public Double getLatestPortfolioValue();
    public void add(PortfolioRequest request);
    public void update(PortfolioRequest request);
    public void delete(Long id);
}
