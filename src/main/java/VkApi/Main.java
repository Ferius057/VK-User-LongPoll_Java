package VkApi;
import VkApi.LongPoll.LongPollJsonParser;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClientException, ApiException, IOException {
        LongPollJsonParser longPoolJsonParser = new LongPollJsonParser();
        longPoolJsonParser.startParsing();
    }
}