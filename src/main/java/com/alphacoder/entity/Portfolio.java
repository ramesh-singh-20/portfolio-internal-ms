package com.alphacoder.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "Portfolio")
@Data
public class Portfolio {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "asset_value", nullable = false)
    private Double assetValue;

    @Column(name= "date", nullable = false)
    private Date date;

    @Column(name= "cumulative_return", nullable = false)
    private Double cumulativeReturn;
}
