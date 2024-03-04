//package com.ruoyi.system.influxdb;
//
//import java.time.Instant;
//import java.util.stream.Stream;
//
//import com.influxdb.v3.client.InfluxDBClient;
//import com.influxdb.v3.client.query.QueryOptions;
//import com.influxdb.v3.client.query.QueryType;
//import com.influxdb.v3.client.write.Point;
//import com.influxdb.v3.client.write.WriteOptions;
//
//public final class DataInsert {
//
//    public static void main(final String[] args) throws Exception {
//        String hostUrl = "https://us-east-1-1.aws.cloud2.influxdata.com";
//        char[] authToken = System.getenv("GDO1GrVFo-Ur7m_1yOv3igtcmrCqhiTJvoUdxBYr84kQCIb0HH_kECknRzR_HTp5wfnk8nelSVtjkPK-M9eGBQ==").toCharArray();
//
//        try (InfluxDBClient client = InfluxDBClient.getInstance(hostUrl, authToken, null)) {
//            String database = "sensors_data";
//
//            Point[] points = new Point[] {
//                    Point.measurement("temperature")
//                            .addField("nodeID",1)//空气温度
//                            .addField("air_temperature", 38.2)
//                            .addField("nodeID",1)//土壤温度
//                            .addField("soil_temperature", 37.5),
//                    Point.measurement("humidity")
//                            .addField("nodeID",1)//空气湿度
//                            .addField("air_humidity", 0.42)
//                            .addField("nodeID",1)//土壤湿度
//                            .addField("soil_humidity", 0.42),
//                    Point.measurement("radiation")
//                            .addField("nodeID",1)//辐射
//                            .addField("radiation", 1.26),
//                    Point.measurement("w_location")
//                            .addField("nodeID",1)//风向
//                            .addField("wind_location", "东"),
//                    Point.measurement("w_speed")
//                            .addField("nodeID",1)//风速
//                            .addField("wind_speed", 300),
//                    Point.measurement("rain")
//                            .addField("nodeID",1)//降水量
//                            .addField("prcp", 1000),
//                    Point.measurement("t_diameter")
//                            .addField("nodeID",1)//树木直径
//                            .addField("diameter", 460),
//            };
//
//            for (Point point : points) {
//                client.writePoint(point, new WriteOptions.Builder().database(database).build());
//
//                Thread.sleep(1000); // separate points by 1 second
//            }
//
//            System.out.println("Complete. Return to the InfluxDB UI.");
//
//
//        }
//
//    }
//}
