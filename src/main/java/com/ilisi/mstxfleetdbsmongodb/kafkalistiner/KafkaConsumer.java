package com.ilisi.mstxfleetdbsmongodb.kafkalistiner;



import com.ilisi.mstxfleetdbsmongodb.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final TripService tripService;

    @KafkaListener(topics = "trip",groupId="{spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Map<String,Object>> record) {
        try {
            Map<String,Object> message = record.value();
            log.info("Message received from Kafka topic trip: {}", message);


            if(message.get("driverId") == null) {
                tripService.addTrip(message.get("passengerId").toString(),
                        Double.parseDouble(message.get("endLatitude").toString()),
                        Double.parseDouble(message.get("endLongitude").toString()));
            } else {
                tripService.acceptTrip(message.get("passengerId").toString(),
                        message.get("driverId").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
