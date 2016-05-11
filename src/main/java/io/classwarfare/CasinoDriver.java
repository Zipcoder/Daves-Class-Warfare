package io.classwarfare;

import java.util.concurrent.TimeUnit;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class CasinoDriver {
    public static void main(String[] args) {
        CasinoDriver casinoDriver=new CasinoDriver();
        casinoDriver.printLogo();
        
    }

    private void printLogo(){
        delayOutput("  _______ .______       _______      ___   .___________.   ____    __    ____  ___       __       __       ");
        delayOutput(" /  _____||   _  \\     |   ____|    /   \\  |           |   \\   \\  /  \\  /   / /   \\     |  |     |  |       ");
        delayOutput("|  |  __  |  |_)  |    |  |__      /  ^  \\ `---|  |----`    \\   \\/    \\/   / /  ^  \\    |  |     |  |       ");
        delayOutput("|  | |_ | |      /     |   __|    /  /_\\  \\    |  |          \\            / /  /_\\  \\   |  |     |  |       ");
        delayOutput("|  |__| | |  |\\  \\----.|  |____  /  _____  \\   |  |           \\    /\\    / /  _____  \\  |  `----.|  `----.  ");
        delayOutput(" \\______| | _| `._____||_______|/__/     \\__\\  |__|            \\__/  \\__/ /__/     \\__\\ |_______||_______|  ");
        delayOutput("");
        delayOutput("                          ______      ___           _______. __  .__   __.   ______                         ");
        delayOutput("                         /      |    /   \\         /       ||  | |  \\ |  |  /  __  \\                        ");
        delayOutput("                        |  ,----'   /  ^  \\       |   (----`|  | |   \\|  | |  |  |  |                       ");
        delayOutput("                        |  |       /  /_\\  \\       \\   \\    |  | |  . `  | |  |  |  |                       ");
        delayOutput("                        |  `----. /  _____  \\  .----)   |   |  | |  |\\   | |  `--'  |                       ");
        delayOutput("                         \\______|/__/     \\__\\ |_______/    |__| |__| \\__|  \\______/                        ");
        delayOutput("");
        delayOutput("");
        delayOutput("____                                                                                                      ____");
        delayOutput("|$  \\\\                                                                                                 // $  |");
        delayOutput("|___//                                                                                                 \\\\____|");
        delayOutput("|                                                                                                            |");
        delayOutput("|                                                                                                            |");
        delayOutput("_____     _____     _____     _____     _____     _____     _____     _____     _____     _____     _____    _       ");
        delayOutput("|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|____|");
        for(int x = 0; x <5;x++){

            delayOutput("_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                    "___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|__");
        }

    }
    private void delayOutput(String s){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
