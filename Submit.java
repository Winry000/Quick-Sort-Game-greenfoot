import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Stack;
import java.io.IOException;
import java.io.* ;
import org.json.* ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.*; 


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Write a description of class submit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submit extends StepButton
{
    private String res = "";
    /**
     * Act - do whatever the submit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Submit()
    {
        GreenfootImage image = getImage() ;
        image.scale( 100, 100 ) ; 
    }
    
     @Get
    public void act() 
    {
        GameStateManager gm = GameStateManager.getInstance();
        GameStates gs = gm.getGameCurrentState();
        if (gs == GameStates.DoneState && isStackEmpty() == true && Greenfoot.mousePressed(this)) {
          
           gm.doClickSubmit();
           gm.showGameCurrentState();
           System.out.println("Sending results.........");
           doSubmit();
     
    }
       // Write the response entity on the console
           // Add your action code here.
    } 
    
    public void doSubmit() {
         QuickSortWorld world = (QuickSortWorld)this.getWorld();
            System.currentTimeMillis();
           long timeEnd = System.currentTimeMillis();
           long timeBegan = world.getTimeBegan();
           long secondsPassed = (timeEnd - timeBegan) /1000;
           int num = world.getNumber();
           String name = world.getPlayerName();
           System.out.println("time:" + secondsPassed);
           System.out.println("digits:" + num);
           System.out.println("name:" + name);
           res = "time:" + secondsPassed + " digits:" + num + " name:" + name;
           System.out.println("res:" + res);
           world.setFinalResult(res);
           String number = "";
           String time = Long.toString(secondsPassed);
           
          ClientResource resource = new ClientResource("http://1-dot-cmpe202wings.appspot.com/cmpe202wings/");

          resource.setMethod(Method.POST);
          resource.getReference().addQueryParameter("format", "json");
            // resource.getReference().addQueryParameter("access_key", "8QON4KC7BMAYYBCEX");
            if(num == 5) {
                number = "five";
            }else if (num == 8) {
                number = "eight";
            }else if (num == 10) {
                number = "ten";
            }
            // create json object and populate it
            JSONObject obj = new JSONObject();
            try {
               obj.put("number", number);
               obj.put("name", name);
               obj.put("time", time);
            } catch (JSONException e1) {// handling of exception 
            }

            StringRepresentation stringRep = new StringRepresentation(obj.toString());
            stringRep.setMediaType(MediaType.APPLICATION_JSON);

            try {
               resource.post(stringRep).write(System.out); // exception occurs here
            } catch (Exception e) {// handling of exceptions 
            }
            getJson(number);
            
        }
        
        
    public void getJson(String number) {
         JSONParser parser = new JSONParser();
         System.out.println(number);
        
        try {         
            //URL oracle = new URL(" https://www.google.com/finance/info?client=ig&q=msft,orcl,adbe");
             URL oracle;
            if (number.equals("five")) {
                oracle = new URL("http://1-dot-cmpe202wings.appspot.com/cmpe202wings/five");
            } else if(number.equals("eight")){
                oracle = new URL("http://1-dot-cmpe202wings.appspot.com/cmpe202wings/eight");
            } else {
                oracle = new URL("http://1-dot-cmpe202wings.appspot.com/cmpe202wings/ten");
            }
           
           //URL oracle = new URL("http://freegeoip.net/json/"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {  
                 JSONArray a = (JSONArray) parser.parse(inputLine);
            	 String[] toprank = new String[5];
                // Loop through each item--
            	int n = 0;
            	QuickSortWorld world = (QuickSortWorld)this.getWorld();
                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;
                   if (n < 5) {
                    	String name = (String) tutorials.get("name");
                    	String time = (String) tutorials.get("time");
                    	toprank[n] = "Name:" + name + "   PlayTime:" + time;
                    	System.out.println("Top Rank: "+ (n + 1) + toprank[n]);
                    	n++;
                    }
                }
                world.drawRank(toprank);
            }
             
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
         
    }   
   
    
   
   
    public void submitMethod() {
         //world.drawList(list);
         int i = 3;
    } 
    private boolean isStackEmpty() {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        Stack<Integer> stack = world.stack;
        if (stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
