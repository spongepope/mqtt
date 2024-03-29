package com.ruoyi.system.mqtt;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.service.MqttDateService;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PushCallback implements MqttCallback {
    private static final Logger logger = LoggerFactory.getLogger(MqttPushClient.class);
    @Autowired
    public static PushCallback pushCallback;


    @Resource
    private MqttDateService mqttDateService;
    @Autowired
    private MqttConfig mqttConfig;

    private static MqttClient client;

    private static String _topic;
    private static String _qos;
    private static String _msg;

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        logger.info("连接断开，可以做重连");
        if (client == null || !client.isConnected()) {
            mqttConfig.getMqttPushClient();
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        // subscribe后得到的消息会执行到这里面

        logger.info("接收消息主题 : " + topic);
        logger.info("接收消息Qos : " + mqttMessage.getQos());
        logger.info("接收消息内容 : " + new String(mqttMessage.getPayload()));
        
        String rfid = new String(mqttMessage.getPayload());
        if (rfid.length() == 6) {
            mqttDateService.insert(rfid);
        }
        _topic = topic;
        _qos = mqttMessage.getQos()+"";
        _msg = new String(mqttMessage.getPayload());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        logger.info("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }


    //别的Controller层会调用这个方法来  获取  接收到的硬件数据
    public String receive() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("topic", _topic);
        jsonObject.put("qos", _qos);
        jsonObject.put("msg", _msg);
        return jsonObject.toString();
    }

    public boolean isKeepAlive(){
        MqttConnectOptions options = new MqttConnectOptions();
        int keepAliveInterval = options.getKeepAliveInterval();
        if(keepAliveInterval < 60){
            return true;
        }
        return false;
    }
}
