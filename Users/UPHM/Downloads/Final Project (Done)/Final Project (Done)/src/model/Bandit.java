package model;

import util.RpgUtil;


public class Bandit {

    public double exp;
    public double hp;
    public double attack;
    public double defend;
    public int level;

    public Bandit(int exp) {
        int e = 100;

        this.exp = exp;
        if (this.exp <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor(((exp) / e +1));
        }
        this.hp = (level * 50);
        this.attack = (level * 2);
        this.defend = (level * 1);

    }

    public void printBanditStatus() {
        System.out.println("Level: " + level);
        System.out.println("Exp  : " + exp + "\t ATK : " + attack);
        System.out.println("Hp   : " + hp + "\t DEF : " + defend);

    }

    public void receiveAttack(double hitPoint) {
        System.out.println("Bandit attacked.");
        System.out.println("Ninja"+RpgUtil.ANSI_GREEN+" attack"+RpgUtil.ANSI_RESET+" by " + hitPoint);
        System.out.println("Bandit"+RpgUtil.ANSI_RED+" defend"+RpgUtil.ANSI_RESET+" by " + defend);
        System.out.println("Bandit lose " + (hitPoint - defend) + " Hp");
        hp = hp - (hitPoint - defend);

        System.out.println("Bandit HP : " + hp);
    }
}
