package VkApi.LongPoll;
import VkApi.MessageParser;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ApiTooManyException;
import com.vk.api.sdk.exceptions.ClientException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LongPollJsonParser {
    /*  Парсинг Json нового события  */
    LongPollUrlHandler longPoolUrlHandler = new LongPollUrlHandler();
    MessageParser messageParser = new MessageParser();
    private String URL = longPoolUrlHandler.longPoolUrlHandler();
    public JSONArray jsonArrayMessage;

    public LongPollJsonParser() throws IOException, ClientException, ApiException { }

    private static Float getTime() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ss.SS");
        return Float.parseFloat(formatForDateNow.format(new Date().getTime()));
    }
    private static void time(Float start) {
        float time = getTime() - start;
        if (time < 0.00001) System.err.println("Сообщение обработано за: < 0.00001 сек.");
        else System.err.println("Сообщение обработано за: " + time + " сек.");
    }

    public void startParsing() throws IOException, ClientException, ApiException {
        while (true) {
            Float start = getTime();
            JSONObject jsonObject = new JSONObject(URL);
            JSONArray jsonArray = jsonObject.getJSONArray("updates");
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonArrayMessage = jsonArray.getJSONArray(i);
                if (jsonArrayMessage.length() == 8) {
                    System.out.println(messageParser.messageParser(jsonArrayMessage));
                    time(start);
                }
            }
            try {
                LongPollInfo.longPoolUpdate();
            } catch (ApiTooManyException e) { }
        }
    }
}