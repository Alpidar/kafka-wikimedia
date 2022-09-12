package alpidar.demos.kafka.wikimedia;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import java.net.URI;
import java.util.concurrent.TimeUnit;

public class WikimediaChangesProducer {
    public static void main(String[] args) {
        EventHandler handler = new WikimediaChangeHandler("wikimedia.recentchange");
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        try(EventSource eventSource = new EventSource.Builder(handler, URI.create(url)).build()){
            eventSource.start();
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
