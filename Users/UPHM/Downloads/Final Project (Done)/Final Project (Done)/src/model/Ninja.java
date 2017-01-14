package model;



import util.RpgUtil;
import static java.lang.Math.round;
import java.util.Scanner;

public class Ninja {

    public String name;
    public int level;
    public double exp;
    public double hp;
    public double attackPoint;
    public double defend;
    public int gold;
    public int score;
    public int checkLevel;
    public int days;
    Scanner input = new Scanner(System.in);

    public Ninja(String name,double exp,int days, int gold, int level, int score,double hp) {
        this.name = name;
        this.exp = exp;
        this.checkLevel = checkLevel;
        double e = 100;
        this.level = level;
        this.attackPoint = (level * 3);
        this.defend = (level * 2);
        this.gold = gold;
        this.days = days;
        this.score = score;
        this.hp = hp;
    }

    public void inputNinjaName() {
        System.out.print("Ninja Name : ");
        name = input.nextLine();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printNinjaStatus() {
        RpgUtil.clearScreen();
        System.out.println(RpgUtil.ANSI_GREEN+"\n\n================================================="+RpgUtil.ANSI_RESET);
        System.out.println("*\t\t  Ninja Profile\t\t        *");
        System.out.println(RpgUtil.ANSI_GREEN+"================================================="+RpgUtil.ANSI_RESET);
        System.out.println("Name : " + name + "(" + level + ")");
        System.out.println(RpgUtil.ANSI_BLUE+"Exp"+ RpgUtil.ANSI_RESET +"  : " + exp + RpgUtil.ANSI_RED+ "\t\t\t ATK"+RpgUtil.ANSI_RESET+"   : " + attackPoint);
        System.out.println(RpgUtil.ANSI_PURPLE+"Hp"+RpgUtil.ANSI_RESET+"   : " + hp + "/" + (level * 50.0) +RpgUtil.ANSI_CYAN + "\t\t DEF"+ RpgUtil.ANSI_RESET+ "   : " + defend);
        System.out.println(RpgUtil.ANSI_YELLOW+"Gold"+RpgUtil.ANSI_RESET+" : " + gold + "\t\t\t Score : " + score);
        System.out.println(RpgUtil.ANSI_GREEN+"================================================="+RpgUtil.ANSI_RESET);
    }

    public void receiveAttack(double hitPoint) {
        System.out.println("Ninja Attacked.");
        System.out.println("Bandit"+RpgUtil.ANSI_RED+ " attack"+RpgUtil.ANSI_RESET+ " by " + hitPoint);
        System.out.println("Ninja"+RpgUtil.ANSI_GREEN+" Defend"+RpgUtil.ANSI_RESET+" by " + defend);
        System.out.println("Ninja lose " + (hitPoint - defend) + " HP");
        hp = hp - (hitPoint - defend);
        if (hp > (level * 50)) {
            hp = level * 50;
        } else if (defend > hitPoint) {
            hitPoint = 0;
        }
        System.out.println("Ninja HP : " + hp);
        RpgUtil.delay(500);
        
    }

    public void receiveAttackBoss(double hitPoint) {
        System.out.println("Ninja Attacked.");
        System.out.println("Bandit"+RpgUtil.ANSI_RED+ " attack"+RpgUtil.ANSI_RESET+ " by " + hitPoint);
        System.out.println("Ninja"+RpgUtil.ANSI_GREEN+" Defend"+RpgUtil.ANSI_RESET+" by " + defend);

        hp = hp - (hitPoint - defend);
        if (hp > (level * 50)) {
            hp = level * 50;
        } else if (defend > hitPoint) {
            hitPoint = 0;
        }
        System.out.println("Ninja lose " + (hitPoint - defend) + " HP");
        System.out.println("Ninja HP : " + hp);
        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void getLevelUp() {
        int e = 100;
        System.out.println("Congratulations! You ninja has reached new level.");
        level = (int) Math.floor((exp / e) + 1);
        exp = 0;
        hp = (level * 50);
        attackPoint = (level * 3);
        defend = (level * 2);
        RpgUtil.delay(1000);
    }

    public void healing() {//
        
        System.out.println("\n\n\nHow much HP do you want to restore?"+RpgUtil.ANSI_BLUE+" (1 Hp = 10 Gold)"+RpgUtil.ANSI_RESET);
        int resthp = input.nextInt();
        if (gold > resthp * 10) {
            if (resthp < (level * 50) && (hp + resthp) <= level * 50) {
                hp = resthp + hp;
                gold = gold - (resthp * 10);
                System.out.println("Your Hp restored to " + hp);
                System.out.println("Your Gold : " + gold);
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
                printNinjaStatus();
            } else {
                System.out.println("Please input before your health limit ");
                RpgUtil.clearScreen();
                System.out.println();
                System.out.println();
                printNinjaStatus();
            }
        } else {
            System.out.println("You Don't have enough Gold");
            printNinjaStatus();
        }
    }
}
