package dkkovalev.com.streamapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by d.kovalev on 15.06.2016.
 */
public class TopChannelsModel implements Serializable {

    private ArrayList<Top> top;


    public TopChannelsModel(ArrayList<Top> topList) {
        this.top = topList;
    }

    public TopChannelsModel() {
    }

    public ArrayList<Top> getTopList() {
        return top;
    }

    public class Top implements Serializable {
        private int viewers;
        private Game game;

        public Game getGame() {
            return game;
        }

        public void setGame(Game game) {
            this.game = game;
        }

        public int getViewers() {
            return viewers;
        }

        public void setViewers(int viewers) {
            this.viewers = viewers;
        }
    }

    public class Game implements Serializable {
        private String name;
        private Box box;

        public Box getBox() {
            return box;
        }

        public void setBox(Box box) {
            this.box = box;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Box implements Serializable {
        private String large;
        private String medium;
        private String small;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }

}


