package VkApi;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;

public class Connection {
    /*  Подключение к Vk Api  */
    private static final String VK_KEY = "-";
    private static final int USER_ID = 0;

    private static VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
    private static UserActor actor = new UserActor(USER_ID, VK_KEY);

    public VkApiClient vk() { return this.vk; }
    public UserActor actor() { return this.actor; }
    public int userId() { return this.USER_ID; }
}