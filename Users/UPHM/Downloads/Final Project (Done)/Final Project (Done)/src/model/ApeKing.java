package model;

import util.RpgUtil;


public class ApeKing {
    public double hp;
    public double attack;
    public double defend;
    public int level;
    
    public ApeKing() {
        this.level = 20;
        this.hp = (level*2);
        this.attack = (level*1);
    }
    public void printBossStatus() {
        System.out.println("Level: " + level);
        System.out.println("ATK  : " + attack);
        System.out.println("Hp   : " + hp + "\t DEF : " + defend);

    }
    public void receiveAttack(double hitPoint) {
        System.out.println("Ape King attacked.");
        System.out.println("Ninja"+RpgUtil.ANSI_GREEN+" attack"+RpgUtil.ANSI_RESET+" by " + hitPoint);
        System.out.println("Ape King"+RpgUtil.ANSI_GREEN+" defend"+RpgUtil.ANSI_RESET+" by " + defend);
        System.out.println("Ape King lose " + (hitPoint - defend) + " Hp");
        hp = hp - (hitPoint - defend);

        System.out.println("Bandit HP : " + hp);
    }
}


