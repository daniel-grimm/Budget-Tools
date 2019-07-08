package com.dgrimm.app;

/**@author Daniel Grimm
 * 
 * This is a library file for the Budget-Tools calculator.
 */

 public class Calc {

    /**Returns what the amount multiplied by the given percent.
     * @param amount : The amount to be multiplied by
     * @param percent : The percent of the amount
     * @return : The percentage of the amount
     */
    public static double percentOf(double amount, double percent) {
        return amount * (percent / 100);
    }

 }