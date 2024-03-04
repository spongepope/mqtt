package com.ruoyi.system.influxdb;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.HashMap;

public class Write {
    @Autowired
    private static char[] token = "xJN1-E00jFoEcSVluy7muRqkQqi8Q1YZUVixFQ5c9-1hNXbnis4BJP9KZHg-NwGTdlhT-KefUc-_1DiawPYu_A==".toCharArray();
    private static String bucket = "sensors_data";
    private static String org = "njupt";


    public static   void main(String[] args) {
        InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token, org, bucket);
        // Write data
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        // Write by Data Point
        Point point = Point
                .measurement("temperature")
                .addField("nodeID", 1)
                .addField("air_temperature", 38.2)
                .addField("nodeID",2)
                .addField("soil_temperature", 37.5)
                .time(Instant.now(), WritePrecision.MS);
                writeApi.writePoint(point);
                client.close();
    }
    @Measurement(name = "temperature")
    private static class Temperature {

        @Column(tag = true)
        String location;

        @Column
        Double value;

        @Column(timestamp = true)
        Instant time;
    }
}
