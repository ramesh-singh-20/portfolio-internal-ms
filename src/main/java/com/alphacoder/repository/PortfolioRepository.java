package com.alphacoder.repository;

import com.alphacoder.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllByOrderByDateAsc();

    @Query(value = "SELECT asset_value FROM portfolio ORDER BY date DESC LIMIT 1;", nativeQuery = true)
    Optional<Double> findLatestAssetValue();
}