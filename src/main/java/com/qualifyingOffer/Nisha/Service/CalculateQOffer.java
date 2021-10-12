package com.qualifyingOffer.Nisha.Service;

import com.qualifyingOffer.Nisha.Model.Player;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CalculateQOffer {



    public List<Player> processPlayerData() throws IOException {

        List<Player> playerList = new ArrayList<>();
        String playerData = getPlayerData();

        String[] players = playerData.split("MLB");

        //System.out.println("Contents of the web page: "+players[1]);

        for(String player : players){
            String[] playerInfo = player.split("\\$");
                if(playerInfo.length > 1 && playerInfo[1].length() > 2) {
                    String salary = playerInfo[1].substring(0, playerInfo[1].length() - 4);

                    Player player1 = new Player();
                    player1.setName(playerInfo[0]);
                    player1.setSalary(playerInfo[1]);
                    player1.setYear("2016");

                    playerList.add(player1);

                }
        }

        return playerList;

    }



    public String getPlayerData() throws IOException {

        //Instantiating the URL class
        URL url = new URL("https://questionnaire-148920.appspot.com/swe/data.html");
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
       // System.out.println(result);
        //Removing the HTML tags
        result = result.replaceAll("<[^>]*>", "");
        //System.out.println("Contents of the web page: "+result);

        return result;
    }


}
