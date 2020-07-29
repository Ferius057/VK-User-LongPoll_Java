package VkApi.LongPoll;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LongPollUrlHandler {
    /*  Получение и парсинг URL  */
    LongPollInfo longPoolInfo = new LongPollInfo();
    private String LongPoolServer = longPoolInfo.longPoolServer();
    private String LongPoolKey = longPoolInfo.longPoolKey();
    private Integer LongPoolTs = longPoolInfo.longPoolTs();

    private String LongPoolUrl = "https://" + LongPoolServer + "?act=a_check&key=" + LongPoolKey + "&wait=25&mode=2&ts=" + LongPoolTs + "&version=3";

    public LongPollUrlHandler() throws ClientException, ApiException { }

    public String longPoolUrlHandler() throws IOException {
        URL obj = new URL(LongPoolUrl);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
