package com.wd;

import java.util.*;
import java.util.logging.Logger;

public class PokerGame {
    //poker牌初始化值
    private static volatile List<String> poker=new ArrayList<>();
    //初始化的player
    private static List<String> player=new ArrayList<>(Arrays.asList("甲", "乙", "丙", "丁"));
    //排序过的player
    private static List<String> sortedPlayer=new ArrayList<>();
    static Random random=new Random();

    //private static Logger logger=Logger.getLogger("com.wd.PokerGame");

    public static void main(String[] args) {
        //扑克牌poker初始化
        for(int i=1;i<=13;i++){
            poker.add(i+"A");
            poker.add(i+"B");
            poker.add(i+"C");
            poker.add(i+"D");
        }
        poker.add("20K");
        poker.add("20Q");
        //随机分配对手和排序
        int player1=random.nextInt(player.size());
        sortedPlayer.add(player.get(player1));
        player.remove(player1);
        int player2=random.nextInt(player.size());
        sortedPlayer.add(player.get(player2));
        player.remove(player2);
        int player3=random.nextInt(player.size());
        sortedPlayer.add(player.get(player3));
        player.remove(player3);
        sortedPlayer.add(player.get(0));
        //分别拿牌
        List<String> gamerContext1=new ArrayList<>();
        List<String> gamerContext2=new ArrayList<>();
        List<String> gamerContext3=new ArrayList<>();
        List<String> gamerContext4=new ArrayList<>();
        for(int i=0;i<13;i++){
            int one=random.nextInt(poker.size());
            gamerContext1.add(poker.get(one));
            poker.remove(one);
            int two=random.nextInt(poker.size());
            gamerContext2.add(poker.get(two));
            poker.remove(two);
            int three=random.nextInt(poker.size());
            gamerContext3.add(poker.get(three));
            poker.remove(three);
            int four=random.nextInt(poker.size());
            gamerContext4.add(poker.get(four));
            poker.remove(four);
        }
        //game1和game3一组，game2和game4一组
        Gamer gamer1=new Gamer(sortedPlayer.get(0),gamerContext1,new ArrayList<>());
        Gamer gamer2=new Gamer(sortedPlayer.get(1),gamerContext2,new ArrayList<>());
        Gamer gamer3=new Gamer(sortedPlayer.get(2),gamerContext3,new ArrayList<>());
        Gamer gamer4=new Gamer(player.get(0),gamerContext4,new ArrayList<>());
        System.out.println("拿/出牌顺序："+gamer1.getName()+gamer2.getName()+gamer3.getName()+gamer4.getName()+
                "。组队，1号队："+gamer1.getName()+","+gamer3.getName()+",2号队："+gamer2.getName()+","+gamer4.getName());
        Gamer[] gamers=new Gamer[]{gamer1,gamer2,gamer3,gamer4};
        for(int i=0;i<gamers.length;i++){
            StringBuilder sb=new StringBuilder();
            sb.append(gamers[i].getName()+" ");
            for(int num=0;num<gamers[i].getPokerContent().size();num++){
                if(num==12){
                    sb.append(gamers[i].getPokerContent().get(num));
                }
                else{
                    sb.append(gamers[i].getPokerContent().get(num)+",");
                }
            }
            //输出分牌情况
            System.out.println(sb);
        }
        gameStart(gamers);
        System.out.println("得分");
        for(int i=0;i<gamers.length;i++){
            int score=0;
            for(String e:gamers[i].getPokerFinally()){
                score+=Integer.parseInt(e.split("\\D")[0]);
            }
            //输出得分
            System.out.println(gamers[i].getName()+" "+score);
        }

    }

    //game start
    private static void gameStart(Gamer[] gamers){
        for(int i=0;i<13;i++){
            //获胜策略--每次取最大值--这段代码需要优化
            String pokerNum1=Collections.max(gamers[0].getPokerContent());
            //String pokerNum1=gamers[0].getPokerContent().get(random.nextInt());
            //String[] pokerCompare1={pokerNum1.split("\\D")[0],pokerNum1.split("\\d")[1]};
            String pokerNum2=Collections.max(gamers[1].getPokerContent());
            //String pokerNum2=gamers[1].getPokerContent().get(i);
            //String[] pokerCompare2={pokerNum2.split("\\D")[0],pokerNum2.split("\\d")[1]};
            String pokerNum3=Collections.max(gamers[2].getPokerContent());
            //String pokerNum3=gamers[2].getPokerContent().get(i);
            //String[] pokerCompare3={pokerNum3.split("\\D")[0],pokerNum3.split("\\d")[1]};
            String pokerNum4=Collections.max(gamers[3].getPokerContent());
            //String pokerNum4=gamers[3].getPokerContent().get(i);
            //String[] pokerCompare4={pokerNum4.split("\\D")[0],pokerNum4.split("\\d")[1]};
            int max=0;
            String maxPoker= pokerNum1;
            String[] compare=new String[]{pokerNum1,pokerNum2,pokerNum3,pokerNum4};
            for(int j=0;j<compare.length;j++){
                //得分比较策略--可扩展
                Integer maxPokerNum=Integer.parseInt(maxPoker.split("\\D")[0]);
                Integer comPokerNum=Integer.parseInt(compare[j].split("\\D")[0]);
                String maxPokerCol=maxPoker.split("\\d")[1];
                String comPokerCol=compare[j].split("\\d")[1];
                if(maxPokerNum<comPokerNum){
                    max=j;
                    maxPoker=compare[j];
                }else if(maxPokerNum==comPokerNum && maxPokerCol.compareTo(comPokerCol)<0){
                    max=j;
                    maxPoker=compare[j];
                }
            }
            Gamer maxPlayer=gamers[max];
            maxPlayer.getPokerFinally().add(pokerNum1);
            maxPlayer.getPokerFinally().add(pokerNum2);
            maxPlayer.getPokerFinally().add(pokerNum3);
            maxPlayer.getPokerFinally().add(pokerNum4);
            //剔除掉已比较掉元素
            gamers[0].getPokerContent().remove(pokerNum1);
            gamers[1].getPokerContent().remove(pokerNum2);
            gamers[2].getPokerContent().remove(pokerNum3);
            gamers[3].getPokerContent().remove(pokerNum4);
        }

    }
}
