package me.uerkwitz;

import me.uerkwitz.botUtils.*;
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.security.auth.login.LoginException;
import org.json.simple.parser.ParseException;
import ch.qos.logback.classic.Logger;


public class McServerBot{
    public static void main(String[] args){
        // TODO: Make an McServerBot Logger for error handling
        // TODO: Implement Logger (LOGBACK-CLASSIC)
        //Make a botUtils worker & setup configurations
        BotUtility WorkerBot = new BotUtility();
        try{
            WorkerBot.configSetup();
        }catch (ParseException | IOException e){
            //Setup failed, TODO: print exception type & log error
            e.printStackTrace();
            return;
        }

        // Build & Login API to bot.
        try{
            //Login
            JDABuilder jdaBuilder = new JDABuilder(WorkerBot.getConfig().getBotToken());
            Game STARTUP_GAME = Game.playing("IDLE");
            jdaBuilder.setGame(STARTUP_GAME);
            JDA jda = jdaBuilder.build();
            jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            System.out.println("Finished Building JDA!"); // TODO: change this to logger ? 
        }catch (LoginException e){// Authentication Error Logging
            e.printStackTrace();
        }catch (InterruptedException e){
            //Due to the fact that awaitReady is a blocking method, one which waits until JDA is fully loaded,
            // the waiting can be interrupted. This is the exception that would fire in that situation.
            e.printStackTrace();
        }

    }
}