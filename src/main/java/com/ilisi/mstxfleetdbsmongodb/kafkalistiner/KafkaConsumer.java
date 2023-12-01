package com.ilisi.mstxfleetdbsmongodb.kafkalistiner;



import com.ilisi.mstxfleetdbsmongodb.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final TripService tripService;

    @KafkaListener(topicPartitions = @TopicPartition(topic = "trip", partitions = {"0"}),
            groupId="{spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Map<String,Object>> record) {
        try {
            Map<String,Object> message = record.value();
            log.info("Message received from Kafka topic trip: {}", message);

            if(message.get("driverId") == null) {
                tripService.addTrip(
                        message.get("tripId").toString(),
                        message.get("passengerId").toString(),
                        Double.parseDouble(message.get("endLatitude").toString()),
                        Double.parseDouble(message.get("endLongitude").toString()),
                        Double.parseDouble(message.get("startLatitude").toString()),
                        Double.parseDouble(message.get("startLongitude").toString()),
                        message.get("status").toString(),
                        message.get("created_at").toString());


            } else {
                tripService.acceptTrip(
                        message.get("tripId").toString(),
                        message.get("driverId").toString(),
                        message.get("status").toString(),
                        message.get("updated_at").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
