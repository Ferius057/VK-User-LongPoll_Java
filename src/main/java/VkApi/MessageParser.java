package VkApi;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.json.JSONArray;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageParser {
    /*  Парсинг Json сообщения  */
    private static int TimeUnix;
    private static String Time;
    private static String UserId;
    private static String UserIdParsing;
    private static String MessageId;
    private static String PeerId;
    private static String Message;


    public String messageParser(JSONArray jsonMessage) throws ClientException, ApiException, IOException {
        messageParseTime(Time);
        TimeUnix = Integer.parseInt(String.valueOf(jsonMessage.get(4)));
        UserIdParsing = String.valueOf(jsonMessage.get(6));
        MessageId = String.valueOf(jsonMessage.get(1));
        PeerId = String.valueOf(jsonMessage.get(3));
        Message = String.valueOf(jsonMessage.get(5));
        messageFromParsing(UserId);
        /*  Так же можно парсить другие собития. */
        return messageRun();
    }

    public void messageParseTime(String formattedDate) {
        long unixSeconds = TimeUnix;
        Date date = new java.util.Date(unixSeconds * 1000L);
        SimpleDateFormat TimeSdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = TimeSdf.format(new Date()); 
        this.Time = formattedDate;
    }

    public void messageFromParsing(String userId) {
        JsonElement jsonParser = new JsonParser().parse(UserIdParsing);
        JsonObject jsonObject = jsonParser.getAsJsonObject();
        userId = String.valueOf(jsonObject.get("from")).replace("\"", "");
        this.UserId = userId;
    }

    public String messageRun() throws ClientException, ApiException, IOException {
        String msg = Message.replace("&quot;","\"");
        String text = "--------------------------------" +
                "\nLog: " +
                "\nTime: " + Time +
                "\nПользователь: " + UserId +
                "\nИд сообщения: " + MessageId +
                "\nБеседа: " + PeerId +
                "\nСообщение: " + msg;
        return text;
    }
}
