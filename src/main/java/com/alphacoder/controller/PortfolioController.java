package com.alphacoder.controller;

import com.alphacoder.domain.request.PortfolioRequest;
import com.alphacoder.domain.response.ResponseDto;
import com.alphacoder.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alphacoder.domain.response.ResponseStatus;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/portfolio")
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
@CrossOrigin
public class PortfolioController {
    private final PortfolioService service;

    @GetMapping
    public ResponseEntity<ResponseDto> getPortfolioDetails(){
        return ResponseEntity.ok(ResponseDto.forSuccess(this.service.getPortfolioDetails()));
    }

    @GetMapping(value = "/asset")
    public ResponseEntity<ResponseDto> getLatestAssetValue(){
        return ResponseEntity.ok(ResponseDto.forSuccess(this.service.getLatestPortfolioValue()));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addTrade(@Valid @RequestBody PortfolioRequest request){
        this.service.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ResponseStatus.SUCCESS, null));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateTrade(@Valid @RequestBody PortfolioRequest request){
        this.service.update(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDto(ResponseStatus.SUCCESS, null));
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<ResponseDto> deleteTradeById(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ResponseStatus.SUCCESS, null));
    }
}
