package userinterface;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import game.Item;

public class ToolTip {
    private GCompound Interface = new GCompound();
    private String text;
    public ToolTip(String text, Item item){
        this.text = text;
        GRect box = new GRect(250,100);
        Color color = new Color(0, 0, 0, 75);
        box.setFillColor(color);
        box.setFilled(true);
        Interface.add(box);
        addLabels(Interface, text);
        Font TitleFont = new Font("Arial", Font.BOLD, 25);
        GLabel title = new GLabel(item.name);
        title.setFont(TitleFont);
        title.setLocation(Interface.getX(), Interface.getY() + 25);
        Interface.add(title);
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
    public GCompound getInterface(){
        return Interface;
    }
    public void addLabels(GCompound Interface, String txt){
        //add labels and if the text is too long, add a new line
        ArrayList<GLabel> labels = new ArrayList<GLabel>();
        String[] words = txt.split(" ");
        String line = "";
        if(txt.length() < 40){
            labels.add(new GLabel(txt));
        }else{
            for(int i = 0; i < words.length; i++){
                line += words[i] + " ";
                if(i == words.length-2){
                        line += words[i+1] + " ";
                        labels.add(new GLabel(line));
                    }
                if(line.length() + words[i].length() > 39){
                    labels.add(new GLabel(line));
                    line = "";

            }
        }
    }


        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setLocation(Interface.getX(), Interface.getY() + 25+ (i+1)*15);
            Interface.add(labels.get(i));
        }
    }
}
