package com.example.couponapi.service;

import com.example.couponapi.controller.dto.CouponIssueRequestDto;
import com.example.couponcore.component.DistributeLockExecutor;
import com.example.couponcore.service.AsyncCouponIssueServiceV1;
import com.example.couponcore.service.AsyncCouponIssueServiceV2;
import com.example.couponcore.service.CouponIssueService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponIssueRequestService {

    private final CouponIssueService couponIssueService;
    private final AsyncCouponIssueServiceV1 asyncCouponIssueServiceV1;
    private final AsyncCouponIssueServiceV2 asyncCouponIssueServiceV2;
    private final DistributeLockExecutor distributeLockExecutor;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void issueRequestV1(CouponIssueRequestDto requestDto) {
        couponIssueService.issue(requestDto.couponId(), requestDto.userId());
        log.info("쿠폰 발급 완료. couponId: %s, userId: %s".formatted(requestDto.couponId(), requestDto.userId()));
    }

    public void asyncIssueRequestV1(CouponIssueRequestDto requestDto) {
        asyncCouponIssueServiceV1.issue(requestDto.couponId(), requestDto.userId());
    }

    public void asyncIssueRequestV2(CouponIssueRequestDto requestDto) {
        asyncCouponIssueServiceV2.issue(requestDto.couponId(), requestDto.userId());
    }
}
