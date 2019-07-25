package com.dgrimm.app;

import java.io.IOException;

/** Initialization that starts up the Budget Tools front page. */

class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("firefox  ../stylesheets/welcome.html");
            pr.getClass();
        } catch (IOException e) {
            System.err.println("Unknown Exception, Exiting...");
			e.printStackTrace();
		}
    }

}