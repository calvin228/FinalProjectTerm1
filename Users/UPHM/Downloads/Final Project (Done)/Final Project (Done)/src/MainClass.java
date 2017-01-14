
import model.Ninja;
import model.Bandit;
import model.ApeKing;
import util.RpgUtil;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.fusesource.jansi.AnsiConsole;
import step03.FileUtil;
import step04.FileUtilV4;

public class MainClass {

    private static Ninja ninja;

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        Integer menu = 0;

        int x = 1;//pengulang

        Scanner input = new Scanner(System.in);

        while (x == 1) {
            x = 0;
            try {
               
                System.out.println("Welcome to Ninja Strike!(ニンジャストライクー!)");
                System.out.println("1.Start Game");
                System.out.println("2.Load Game");
                System.out.println("3.Exit Game");
                System.out.println("4.About");

                System.out.println(RpgUtil.ANSI_RESET+"\nYour Choice : ");

                menu = Integer.parseInt(input.next());

            } catch (Exception e) {
                System.out.println("Please input numbers , not alphabets");

                x = 1;

            }

        }

        RpgUtil.clearScreen();
        if (menu == 1) {
            System.out.println("\n\nHello Player.");
            System.out.println("Create Your Own Fabulous Ninja!");

            System.out.println("Ninja Name : ");
            String name = input.next();

            ninja = new Ninja(name, 0.0, 1, 500, 1, 0, 50);

            System.out.print("Creating Ninja ");

            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.println(".");
            System.out.print("Preparing New Character ");
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.println(".");
            System.out.println("Your Fabulous Ninja Created!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
            System.out.println();
            ninja.printNinjaStatus();
            System.out.println();

            playGame();

        } else if (menu == 2) {
//            Load Game
            FileUtilV4 futil = new FileUtilV4();
            String s1 = futil.openReadFile("Ninja.txt");
            System.out.println(s1);
            String name = "";
            double exp = 0;
            int days = 1;
            int gold = 500;
            int level = 1;
            int score = 0;
            double hp = 0;
            while (futil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter
                String[] readLine = futil.getReadScanner().next().split(",");

                // printout per line
                name = readLine[0];
                exp = Double.parseDouble(readLine[1]);
                days = Integer.parseInt(readLine[2]);
                gold = Integer.parseInt(readLine[3]);
                level = Integer.parseInt(readLine[4]);
                score = Integer.parseInt(readLine[5]);
                hp = Double.parseDouble(readLine[6]);
                System.out.println("Reading Name  = " + name);
                RpgUtil.delay(800);
                System.out.println("Reading Exp   = " + exp);
                RpgUtil.delay(800);
                System.out.println("Reading Days  = " + days);
                RpgUtil.delay(800);
                System.out.println("Reading Gold  = " + gold);
                RpgUtil.delay(800);
                System.out.println("Reading Level = " + level);
                RpgUtil.delay(800);
                System.out.println("Reading Score = " + score);
                RpgUtil.delay(800);
                System.out.println("Reading Hp    = " + hp);
                RpgUtil.delay(800);
            }

            String s3 = futil.closeReadFile();
            System.out.println(s3);
            System.out.println("Game loaded . . .\n");
            RpgUtil.delay(2000);
            RpgUtil.clearScreen();
            ninja = new Ninja(name, exp, days, gold, level, score, hp);
            ninja.printNinjaStatus();
            playGame();
        } else if (menu == 3) {
            System.out.print("Quitting ");
            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.print(".");
            RpgUtil.delay(1000);
            System.out.print(".");
            System.exit(0);
        } else if (menu == 4) {
            System.out.println("- Calvin Octa Wijaya(00000023147)");
            System.out.println("- Alvin Wijaya      (00000023157)");
            System.out.println("UPH Medan 2016. IS");
            
        }
    }

    public static void playGame() {
        Scanner input = new Scanner(System.in);
        int earnGold, earnXP, earnScore;
        boolean y = true;
        boolean y1 = true;
        boolean y2 = true;
        Integer battleOption = 0;
        Integer menu_game = 0;
        boolean game;

        while (game = true) {
            if (ninja.days <= 730) {
                if (ninja.level < 51) {
                    while (y == true) {
                        y = false;
                        try {
                            
                            System.out.println("Day - " + RpgUtil.ANSI_BLUE + ninja.days+RpgUtil.ANSI_RESET);
                            System.out.println("Menu");
                            System.out.println("1.Start Battle");
                            System.out.println("2.Check Profile");
                            System.out.println("3.Boss Battle");
                            System.out.println("4.Heal Ninja");
                            System.out.println("5.Save Game");
                            System.out.println("6.Exit Game");
                            System.out.println("Choose your menu : ");
                            menu_game = Integer.parseInt(input.next());
                            
                            y = false;
                        } catch (Exception e) {
                            System.out.println("Please input" +RpgUtil.ANSI_GREEN +" numbers"+RpgUtil.ANSI_RESET+ " , not"+RpgUtil.ANSI_RED+"alphabets"+RpgUtil.ANSI_RESET);

                            y = true;
                        }
                    }

                    if (menu_game == 1) {
                        RpgUtil.clearScreen();
                        Bandit bandit = new Bandit(RpgUtil.randInt(ninja.level * 70, ninja.level * 99));
                        System.out.println("Here comes the bandit...");
                        bandit.printBanditStatus();
                        while ((ninja.hp > 0 || bandit.hp > 0)) {
                            y1 = true;
                            while (y1 == true) {
                                y1 = false;
                                try {
                                    System.out.println("Battle Menu : ");
                                    System.out.println("1.Attack Enemy");
                                    System.out.println("2.Run Away");
                                    System.out.println("What would you do? ");
                                    battleOption = Integer.parseInt(input.next());
                                    y1 = false;
                                } catch (Exception e) {
                                    System.out.println("Please input" +RpgUtil.ANSI_GREEN +" numbers"+RpgUtil.ANSI_RESET+ " , not"+RpgUtil.ANSI_RED+"alphabets"+RpgUtil.ANSI_RESET);
                                    y1 = true;
                                }
                            }
                            if (battleOption == 1) {
                                bandit.receiveAttack((RpgUtil.randInt((ninja.level * 2), ((ninja.level * 2) + 3 * ninja.level))));

                            } else if (battleOption == 2) {

                                System.out.println("You escaped!");
                                ninja.score -= 100;
                                System.out.println(RpgUtil.ANSI_RED + "You Lose 100 Score"+RpgUtil.ANSI_RESET);
                                bandit.hp = bandit.level * 30;
                                ninja.days++;
                                RpgUtil.delay(1500);
                                playGame();
                                break;

                            }
                            System.out.println("-------------------------------------------");
                            if (bandit.hp == 0 || bandit.hp <= 0) {
                                System.out.println(RpgUtil.ANSI_GREEN+"You Win the battle!"+RpgUtil.ANSI_RESET);
                                earnXP = RpgUtil.randInt(100, 200);
                                ninja.exp += earnXP;
                                earnGold = RpgUtil.randInt(ninja.level * 200, ninja.level * 300);
                                ninja.gold += earnGold;
                                earnScore = RpgUtil.randInt(100, 200);
                                ninja.score += earnScore;
                                System.out.println("You earn XP    : " + earnXP);
                                System.out.println("You earn Gold  : " + earnGold);
                                System.out.println("You earn Score : " + earnScore);
                                if (ninja.exp >= 100 * ninja.level) {
                                    ninja.getLevelUp();
                                    RpgUtil.delay(1000);
                                    RpgUtil.clearScreen();
                                }
                                ninja.printNinjaStatus();
                                bandit.hp = bandit.level * 30;
                                ninja.days++;
                                playGame();
                                break;

                            }
                            ninja.receiveAttack((RpgUtil.randInt((bandit.level * 2), ((bandit.level * 3) + 2 * bandit.level))));
                            System.out.println("-------------------------------------------");
                            if (ninja.hp <= 0 || ninja.hp == 0) {
                                System.out.println("You Lose the battle!");
                                System.out.println("Game Over!");
                                System.exit(0);
                            }
                        }

                    } else if (menu_game == 2) {
                        ninja.printNinjaStatus();
                        playGame();

                    } else if (menu_game == 3) {
                        RpgUtil.clearScreen();
                        ApeKing apeKing = new ApeKing();
                        System.out.println("Here comes the Ape King...");
                        apeKing.printBossStatus();
                        while (ninja.hp > 0 || apeKing.hp > 0) {
                            y2 = true;
                            while (y2 == true) {
                                y2 = false;
                                try {
                                    System.out.println("Battle Menu : ");
                                    System.out.println("1.Attack Enemy");
                                    System.out.println("2.Run Away");
                                    System.out.println("What would you do? ");
                                    battleOption = Integer.parseInt(input.next());
                                    y2 = false;
                                } catch (Exception e) {
                                    System.out.println("Please input" +RpgUtil.ANSI_GREEN +" numbers"+RpgUtil.ANSI_RESET+ " , not"+RpgUtil.ANSI_RED+"alphabets"+RpgUtil.ANSI_RESET);

                                    y2 = true;
                                }
                            }

                            if (battleOption == 1) {
                                apeKing.receiveAttack((RpgUtil.randInt((ninja.level * 2), ((ninja.level * 2) + 3 * ninja.level))));
                            } else {

                                System.out.println("You escaped!");
                                apeKing.hp = apeKing.level * 30;
                                ninja.days++;
                                RpgUtil.delay(1000);
                                RpgUtil.clearScreen();
                                playGame();
                                break;
                            }
                            System.out.println("-------------------------------------------");
                            if (apeKing.hp == 0 || apeKing.hp <= 0) {
                                System.out.println(RpgUtil.ANSI_GREEN + "You Win the battle!"+RpgUtil.ANSI_RESET);
                                earnXP = RpgUtil.randInt(100, 200);
                                ninja.exp += earnXP;
                                earnGold = RpgUtil.randInt(ninja.level * 200, ninja.level * 300);
                                ninja.gold += earnGold;
                                earnScore = RpgUtil.randInt(100, 200);
                                ninja.score += earnScore;
                                System.out.println("You earn XP    : " + earnXP);
                                System.out.println("You earn Gold  : " + earnGold);
                                System.out.println("You earn Score : " + earnScore);
                                if (ninja.exp >= 100 * ninja.level) {
                                    ninja.getLevelUp();
                                }
                                RpgUtil.clearScreen();
                                ninja.printNinjaStatus();
                                //apeKing.hp = apeKing.level * 30;
                                ninja.days++;
                                playGame();
                                break;
                            }
                            ninja.receiveAttackBoss(apeKing.attack);
                            System.out.println("-------------------------------------------");
                            if (ninja.hp <= 0 || ninja.hp == 0) {
                                System.out.println(RpgUtil.ANSI_RED + "You Lose the battle!"+RpgUtil.ANSI_RESET);
                                System.out.println("Game Over!");
                                System.exit(0);
                            }
                        }

                    } else if (menu_game == 4) {

                        if (ninja.gold > 10) {
                            if (ninja.hp < (ninja.level * 50)) {
                                ninja.healing();
                                ninja.days++;
                            } else {        
                                RpgUtil.delay(1);
                                System.out.println("Your HP is already full!");
                                RpgUtil.delay(2000);
                                RpgUtil.clearScreen();
                                
                            }

                        } else {
                            System.out.println("You don't have enough Gold!");
                        }
                        playGame();
                    } else if (menu_game == 5) {
                        RpgUtil.clearScreen();
                        FileUtil futil = new FileUtil();

                        // open existing file
                        String s1 = futil.openWriteFile("Ninja.txt");
                        System.out.println(s1);

                        // define text formatting
                        String txtFormat = "%s,%f,%d,%d,%d,%d,%f";
                        // add record
//                        String name = ninja.name;
//                        double exp = ninja.exp;
                        String s3 = futil.addWriteRecord(txtFormat, ninja.name, ninja.exp, ninja.days, ninja.gold, ninja.level, ninja.score,ninja.hp);
                        System.out.println(s3);

                        String s4 = futil.closeWriteFile();
                        System.out.println(s4);
                        playGame();
                        break;
                    } else {
                        System.out.println("Thank you for playing!");
                        
                        System.exit(0);
                    }

                } else {
                    System.out.println("You have reached the max level of this game.");
                    System.out.println("Game Over. Thank you for playing");
                    
                    System.exit(0);
                }
            } else {
                System.out.println("You have reached the max days");
                System.out.println("Game Over. Thank you for playing.");
                
                System.exit(0);
            }
        }
    }
}
