package com.demo.springbootmybatis.web.controller;

import com.demo.springbootmybatis.dao.domain.Acct;
import com.demo.springbootmybatis.model.common.ResponseResult;
import com.demo.springbootmybatis.service.TestService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<ResponseResult> editAppointmentMerchantUseStatus(
            @ApiParam(value = "orderId", required = true) @RequestParam String orderId,
            @ApiParam(value = "[01:已使用, 02:未使用]") @RequestParam(required = false) String useStatus) {
        log.info("receive a request edit reserve use status by orderId:{},useStatus:{}", orderId, useStatus);
        String responseResult = testService.getOne();
        return new ResponseEntity(responseResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public ResponseEntity<ResponseResult> editAppointmentMerchantUseStatus(
            @RequestParam int pageNum,
            @RequestParam int pageSize,
            @RequestParam String acctNo) {
        log.info("receive a request edit reserve use status by acctNo:{}", acctNo);
        List<Acct> responseResult = testService.getAcctListByAcctNoPagination(pageNum, pageSize, acctNo);
        return new ResponseEntity(responseResult, HttpStatus.OK);
    }
}
