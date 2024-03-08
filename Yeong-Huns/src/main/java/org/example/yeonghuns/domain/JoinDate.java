package org.example.yeonghuns.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : org.example.yeonghuns.domain
 * fileName       : WorkStartDay
 * author         : Yeong-Huns
 * date           : 2024-03-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-08        Yeong-Huns       최초 생성
 */

@RequiredArgsConstructor
public enum JoinDate {
    OVER_ONE_YEAR(15L),
    UNDER_ONE_YEAR(11L);

    private final long maxAnnualLeaves;
    public long getAnnualLeaves(){return maxAnnualLeaves;}
}
