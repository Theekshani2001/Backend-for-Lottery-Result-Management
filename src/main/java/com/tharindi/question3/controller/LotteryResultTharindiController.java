package com.tharindi.question3.controller;

import com.tharindi.question3.model.LotteryResultTharindi;
import com.tharindi.question3.service.LotteryResultTharindiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lottery-results")
public class LotteryResultTharindiController {

    private final LotteryResultTharindiService lotteryResultTharindiService;

    @Autowired
    public LotteryResultTharindiController(LotteryResultTharindiService lotteryResultTharindiService) {
        this.lotteryResultTharindiService = lotteryResultTharindiService;
    }

    @PostMapping
    public ResponseEntity<String> createLotteryResult(@RequestBody LotteryResultTharindi lotteryResult) {
        lotteryResultTharindiService.saveLotteryResult(lotteryResult);
        return ResponseEntity.ok("Lottery result saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<LotteryResultTharindi>> getAllLotteryResults() {
        List<LotteryResultTharindi> results = lotteryResultTharindiService.getAllLotteryResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LotteryResultTharindi> getLotteryResultById(@PathVariable Long id) {
        LotteryResultTharindi result = lotteryResultTharindiService.getLotteryResultById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLotteryResult(@PathVariable Long id) {
        lotteryResultTharindiService.deleteLotteryResult(id);
        return ResponseEntity.ok("Lottery result deleted successfully.");
    }
}
