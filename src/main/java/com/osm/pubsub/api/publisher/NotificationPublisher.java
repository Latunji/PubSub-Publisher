package com.osm.pubsub.api.publisher;

import com.osm.pubsub.api.config.MessagingConfig;
import com.osm.pubsub.api.domain.Data;
import com.osm.pubsub.api.domain.Topic;
import com.osm.pubsub.api.domain.URL;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/subscribe/{topic}", method = RequestMethod.POST)
    public ResponseEntity<Topic> subscribe(@RequestBody URL url, @PathVariable("topic") String topic) {
        Topic t= new Topic();
        t.setTopic(topic);
        t.setUrl(url.getUrl());
        return new ResponseEntity<Topic>(t, HttpStatus.OK);
    }

    @RequestMapping(value = "/publish/{topic}", method = RequestMethod.POST)
    public ResponseEntity<Topic> publish(@RequestBody Data data, @PathVariable("topic") String topic) {
        Topic t= new Topic();
        t.setTopic(topic);
        t.setData(data.getData());
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, t);
        return new ResponseEntity<Topic>(t, HttpStatus.OK);
    }
}
