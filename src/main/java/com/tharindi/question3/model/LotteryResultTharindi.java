package com.tharindi.question3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LotteryResultTharindi {

    @Id
    @Column(updatable = false)
    private Long winningSession;

    private String zodiacSign;
    private String number1;
    private String number2;
    private String number3;
    private String number4;

    public LotteryResultTharindi() {
    }

    public LotteryResultTharindi(Long winningSession, String zodiacSign, String number1, String number2, String number3, String number4) {
        this.winningSession = winningSession;
        this.zodiacSign = zodiacSign;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
    }

    public Long getWinningSession() {
        return winningSession;
    }

    public void setWinningSession(Long winningSession) {
        this.winningSession = winningSession;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }
}
