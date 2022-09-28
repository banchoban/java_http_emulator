package org.example.http_emulator;

public class TestModel {
    private String randValue;
    private String counterValue;
    private String toLog;

    public TestModel(String randValue, String counterValue, String toLog) {
        this.randValue = randValue;
        this.counterValue = counterValue;
        this.toLog = toLog;
    }

    public TestModel() {
    }

    public String getRandValue() {
        return randValue;
    }

    public void setRandValue(String randValue) {
        this.randValue = randValue;
    }

    public String getCounterValue() {
        return counterValue;
    }

    public void setCounterValue(String counterValue) {
        this.counterValue = counterValue;
    }

    public String getToLog() {
        return toLog;
    }

    public void setToLog(String toLog) {
        this.toLog = toLog;
    }
}
