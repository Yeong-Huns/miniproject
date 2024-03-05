package org.example.yeonghuns.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.yeonghuns.dto.commute.request.GetCommuteRecordRequest;
import org.example.yeonghuns.dto.commute.request.endOfWorkRequest;
import org.example.yeonghuns.dto.commute.request.startOfWorkRequest;
import org.example.yeonghuns.dto.commute.response.GetCommuteRecordResponse;
import org.example.yeonghuns.service.commute.CommuteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : org.example.yeonghuns.controller
 * fileName       : CommuteController
 * author         : Yeong-Huns
 * date           : 2024-03-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-04        Yeong-Huns       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class CommuteController {
    private final CommuteService commuteService;

    @PostMapping("/start-of-work")
    public void startOfWork(@Valid @RequestBody startOfWorkRequest request) {
        commuteService.startOfWork(request);
    }

    @PostMapping("/end-of-work")
    public void endOfWork(@Valid @RequestBody endOfWorkRequest request) {
        commuteService.endOfWork(request);
    }

    @GetMapping("/commute")
    public ResponseEntity<GetCommuteRecordResponse> GetCommuteRecord(@Valid GetCommuteRecordRequest request){
        GetCommuteRecordResponse getCommuteRecordResponse = commuteService.GetCommuteRecord(request);
        return ResponseEntity.ok().body(getCommuteRecordResponse);
    }
}
