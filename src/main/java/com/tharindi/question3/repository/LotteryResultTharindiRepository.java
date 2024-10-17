package com.tharindi.question3.repository;

import com.tharindi.question3.model.LotteryResultTharindi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryResultTharindiRepository extends JpaRepository<LotteryResultTharindi, Long> {

}
