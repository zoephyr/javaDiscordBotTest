package me.uerkwitz.botUtils;


public class BotConfigurations{
    private String botToken;
    private String server_ip;
    private String server_port;
    private boolean plugin_enabled;

    // Constructor forces plugin_enabled false, MC Plugin not implemented
    public BotConfigurations(String botToken, String server_ip, String server_port, boolean plugin_enabled){
        this.botToken = botToken;
        this.server_ip = server_ip;
        this.server_port = server_port;
        this.plugin_enabled = false;
    }

    public String getBotToken(){
        return this.botToken;
    }
    public String getIP(){
        return this.server_ip;
    }
    public String getPort(){
        return this.server_port;
    }
    public boolean isPluginEnabled(){
        return this.plugin_enabled;
    }
}