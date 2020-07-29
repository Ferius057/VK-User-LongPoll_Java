package VkApi.LongPoll;
import VkApi.Connection;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.LongpollParams;

import java.io.IOException;

public class LongPollInfo {
    /*  Получение данных Server,Key,Ts для URL  */
    Connection connection = new Connection();
    private VkApiClient vk = connection.vk();
    private UserActor ACTOR = connection.actor();
    private int USER_ID = connection.userId();

    LongpollParams LongPoolInfo = vk.messages().getLongPollServer(ACTOR).execute();

    public LongPollInfo() throws ClientException, ApiException { }

    public String longPoolServer() { return LongPoolInfo.getServer(); }
    public String longPoolKey() { return LongPoolInfo.getKey(); }
    public Integer longPoolTs() { return LongPoolInfo.getTs(); }

    public static void longPoolUpdate() throws ClientException, ApiException, IOException {
        LongPollJsonParser longPoolJsonParser = new LongPollJsonParser();
        longPoolJsonParser.startParsing();
    }
}