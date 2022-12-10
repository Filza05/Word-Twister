/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordgame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static javax.swing.JOptionPane.showMessageDialog;
import wordgame.LevelsJFrame;
import wordgame.StartupJFrame;


public class WordVoyage 
{
    static int noOfGuesses = 5;
    static int level = 1;
    
   
    private static final String[] wordBank = new String[] {"mud","potato","superman","programmer","letter",
    "helium","killogram","simultaneously","registery","balle"};

     
     public void startGame(String guessedWord)
     {
     
         String questionWord = wordBank[level - 1];
         
         
         if (guessedWord.equals(questionWord))
           {
             showMessageDialog(null, " CORRECT!!! Level " + level + " Completed!");
             level++;
             noOfGuesses = 5;
           }
         else if (!guessedWord.equals(questionWord))
           {
             noOfGuesses--;
             showMessageDialog(null, " WRONG!!! Try Again!");  
           }
  
     }
    
    
        public String getShuffledWord()
        {
            String shuffledWord = wordBank[level - 1]; // start with original word
            int wordSize = shuffledWord.length();
            int shuffleCount = 10; // let us randomly shuffle letters 10 times
            for(int i=0;i<shuffleCount;i++) 
            {
            
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
            }     
        return shuffledWord;
        }
        
     
        private String swapCharacters(String shuffledWord, int position1, int position2) 
        {
        char[] charArray = shuffledWord.toCharArray();

        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;      //swapping letters in two indexes
        return new String(charArray);
        }
  
            
}
