package tn.sagemcom.Services;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.ReceiverRecord;
import tn.sagemcom.Repositories.KafkaService;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class KafkaServiceImpl implements KafkaService {


    private Flux<ReceiverRecord<String, String>> testTopicStream;


    KafkaServiceImpl() throws IOException {

    	Map<String,Object> config= new HashMap<>();
    	config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.CLIENT_ID_CONFIG, "reactive-consumer");

     

        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        ReceiverOptions<String, String> receiverOptions = ReceiverOptions.create(config);

        testTopicStream = createTopicCache(receiverOptions, "Kafka_CMS");
    }


    public Flux<ReceiverRecord<String, String>> getTestTopicFlux() {

        return testTopicStream;
    }

    private <T, G> Flux<ReceiverRecord<T, G>> createTopicCache(ReceiverOptions<T, G> receiverOptions, String topicName) {
        ReceiverOptions<T, G> options = receiverOptions.subscription(Collections.singleton(topicName));

        return KafkaReceiver.create(options).receive().cache();
    }
}