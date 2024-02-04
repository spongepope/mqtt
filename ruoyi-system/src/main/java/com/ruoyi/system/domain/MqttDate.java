package com.ruoyi.system.domain;

public class MqttDate {
    private Integer mqtt_id;
    private String mqtt_time;
    private String mqtt_baowen1;
    private String mqtt_baowen2;

    public Integer getMqtt_id() {
        return mqtt_id;
    }

    public void setMqtt_id(Integer mqtt_id) {
        this.mqtt_id = mqtt_id;
    }

    public String getMqtt_time() {
        return mqtt_time;
    }

    public void setMqtt_time(String mqtt_time) {
        this.mqtt_time = mqtt_time;
    }

    public String getMqtt_baowen1() {
        return mqtt_baowen1;
    }

    public void setMqtt_baowen1(String mqtt_baowen1) {
        this.mqtt_baowen1 = mqtt_baowen1;
    }

    public String getMqtt_baowen2() {
        return mqtt_baowen2;
    }

    public void setMqtt_baowen2(String mqtt_baowen2) {
        this.mqtt_baowen2 = mqtt_baowen2;
    }

    @Override
    public String toString() {
        return "MqttDate{" +
                "mqtt_id=" + mqtt_id +
                ", mqtt_time='" + mqtt_time + '\'' +
                ", mqtt_baowen1='" + mqtt_baowen1 + '\'' +
                ", mqtt_baowen2='" + mqtt_baowen2 + '\'' +
                '}';
    }
}
