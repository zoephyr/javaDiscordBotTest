package me.uerkwitz.botUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class BotUtility{
    //private final String configPath = "config.json";
    private BotConfigurations config;

    public void configSetup() throws IOException, ParseException{
        //String configPath = "src/main/configs/config.json"; //Use for IDE
        String configPath = "./config/config.json"; // TODO: Use for JAR
        
        JSONParser jsonParser = new JSONParser();
        JSONObject configJSON = (JSONObject) jsonParser.parse(new FileReader(configPath) );
        String botToken = (String)configJSON.get("token");
        String server_ip = (String)configJSON.get("ip");
        String server_port = (String)configJSON.get("port");
        boolean plugin_enabled = (boolean)configJSON.get("plugin_enabled");
        this.config = new BotConfigurations(botToken, server_ip, server_port, plugin_enabled);
    }
    public BotConfigurations getConfig(){
        return this.config;
    }

}