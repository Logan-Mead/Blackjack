/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.albany.lab9;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author loganmead
 */
public class GameOf21 {
    private static String[] cards = {"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "Jack", "Queen", "King", "Ace"};    
    private static int[] points = {1,2,3,4,5,6,7,8,9,10,10,10,10,11};
    
    public static void main(String[] args){
        Random rand = new Random();
        int card1 = rand.nextInt(13);
        int card2 = rand.nextInt(13);
        
        System.out.println("Your Cards are: "+cards[card1]+","+cards[card2]);
        /*System.out.print("Your Cards are: ");
        System.out.print(cards[card1]);
        System.out.print(",");
        System.out.println(cards[card2]);
*/
        int score = points[card1] + points[card2];
        System.out.println("You have: "+score+" Points");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to Hit or Stand?: ");
        String action = scanner.nextLine();
        
        if (action.equalsIgnoreCase("stand")){
            int dCard1 = rand.nextInt(13);
            int dCard2 = rand.nextInt(13);
            int dScore = points[dCard1] + points[dCard2];
            System.out.println("Dealer cards: " + dCard1+" " + dCard2);
            System.out.println("Dealer points: " +dScore);
            if(dScore < 16){
                int dNextCard = rand.nextInt(13);
                dScore = points[dNextCard] + dScore;
                System.out.println("Dealer card: " + dNextCard);
                System.out.println("Dealer score: " + dScore);
            } 

            if (dScore > score && score <= 21 && dScore <= 21){
                System.out.println("Dealer won! you lost");
                return;
            }
            else if(score > dScore && score <= 21){
               System.out.println("You won!");
            }
            else if(score > 21){
                System.out.println("YOU LOST! over 21");
                return;
            }
        }
        int dCard1 = rand.nextInt(13);
        int dCard2 = rand.nextInt(13);
        int dScore = points[dCard1] + points[dCard2];
        while (action.equalsIgnoreCase("hit")){ 
            // Get new card
            int nextCard = rand.nextInt(13);
            System.out.println("Next Card is a: "+cards[nextCard]);
            score = score + points[nextCard];
            System.out.println("You have: "+score+" Point");
            if (score > 21){
                System.out.println("YOU BUSTED! you lost");
                return;
            }
            System.out.println("Do you want to Hit or Stand?: ");
            action = scanner.nextLine();
            int count = 0;
            count = count + 1;
            if (count == 1){
                System.out.println("Dealer cards: " + dCard1 +" " + dCard2);
                System.out.println("Dealer points: " +dScore);
            }
            if(count > 1 && dScore < 16){
                int dNextCard = rand.nextInt(13);
                dScore = points[dNextCard] + dScore;
                System.out.println("Dealer card: " + dNextCard);
                System.out.println("Dealer score: " + dScore);
            } 
        }
        if (action.equalsIgnoreCase("stand")){
            if (dScore > score && score <= 21 && dScore <= 21){
                System.out.println("Dealer won! you lost");
                return;
            }
            else if(score > dScore && score <= 21){
               System.out.println("You won!");
            }
            else if(score > 21){
                System.out.println("YOU LOST! over 21");
                return;
            }
        }
    } 
}
