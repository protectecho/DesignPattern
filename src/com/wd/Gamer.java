package com.wd;

import java.util.List;

public class Gamer {
    private String name;
    private List<String> pokerContent;

    public List<String> getPokerFinally() {
        return pokerFinally;
    }

    public void setPokerFinally(List<String> pokerFinally) {
        this.pokerFinally = pokerFinally;
    }

    //最终的牌数
    private List<String> pokerFinally;

    public Gamer(){
    }

    public Gamer(String name, List<String> pokerContent, List<String> pokerFinally) {
        this.name = name;
        this.pokerContent = pokerContent;
        this.pokerFinally = pokerFinally;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPokerContent() {
        return pokerContent;
    }

    public void setPokerContent(List<String> pokerContent) {
        this.pokerContent = pokerContent;
    }
}
