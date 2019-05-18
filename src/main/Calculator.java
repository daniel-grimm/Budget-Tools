/**@author Daniel Grimm
 * @version 0.0
 * 
 * This is a library file for the Budget-Tools calculator.
 */

 public class Calculator {

    /**Returns what the amount multiplied by the given percent.
     * @param amount : The amount to be multiplied by
     * @param percent : The percent of the amount
     * @return : The percentage of the amount
     */
    public static double percentOf(double amount, double percent) {
        return amount * (percent / 100);
    }

 }