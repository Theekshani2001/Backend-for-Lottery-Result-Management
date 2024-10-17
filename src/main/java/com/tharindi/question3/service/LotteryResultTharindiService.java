package com.tharindi.question3.service;

import com.tharindi.question3.model.LotteryResultTharindi;
import com.tharindi.question3.repository.LotteryResultTharindiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryResultTharindiService {

    private final LotteryResultTharindiRepository lotteryResultTharindiRepository;

    @Autowired
    public LotteryResultTharindiService(LotteryResultTharindiRepository lotteryResultTharindiRepository) {
        this.lotteryResultTharindiRepository = lotteryResultTharindiRepository;
    }

    public void saveLotteryResult(LotteryResultTharindi lotteryResult) {
        lotteryResultTharindiRepository.save(lotteryResult);
    }

    public List<LotteryResultTharindi> getAllLotteryResults() {
        return lotteryResultTharindiRepository.findAll();
    }

    public LotteryResultTharindi getLotteryResultById(Long id) {
        return lotteryResultTharindiRepository.findById(id).orElse(null);
    }

    public void deleteLotteryResult(Long id) {
        lotteryResultTharindiRepository.deleteById(id);
    }
}
