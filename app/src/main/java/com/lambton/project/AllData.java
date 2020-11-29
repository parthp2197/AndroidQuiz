package com.lambton.project;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AllData {
    private int score=0;
     private String[] questions = new String[]{
                "Which one cannot be or is much more difficult to manipulate in balance sheet?",
                "Which of the following would be considered a use of funds?",
                "If two firms in the same line of business merge together, it is known as which merger.",
                "An investment should be accepted if its Net Present Value (NPV) is",
                "The sale of financial assets is also referred to as the",
                "The construction of new manufacturing plant is also referred to as the",
                "Which from the following is NOT an example of intangible assets?",
                "In Finance, risk is calculated by calculating the",
                "The cost of monitoring management is considered to be an "
        };


        private String[][] answers = new String[][]{
                {"Cash flows", "Assets", "Liabilities", "Equity", "Cash flows"},
                {"Increase in cash", "Decrease in receivables", "decrease in cash", "increase in payables", "Increase in cash"},
                {"Horizontal", "Vertical", "Straight", "Conglomerate", "Horizontal"},
                {"Negative", "Positive", "0", "1", "Positive"},
                {"Capital decision", "CFO decision", "Financing decision", "Investments", "Financing decision"},
                {"Capital decision", "CFO decision", "Financing decision", "Investment decisions", "Investment decisions"},
                {"Trademarks", "Patents", "Buildings", "Technical expertise", "Buildings"},
                {"Mean", "Variance", "Standard variation", "Kurtosis", "Standard variation"},
                {"Bankruptcy cost", "Transaction cost", "Agency cost", "Institutional cost", "Agency cost"}
        };

        public int[] getRadnom(){
            Random r = new Random();
            int[] arr = new int[4];
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=0; i<9; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i=0; i<4; i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }



        public String  getQuestion(int index)
        {
            return questions[index];
        }
        public String getAnswers(int index, int index2)
        {
            return answers[index][index2];
        }

        public int getScore()
        {
            return score;
        }


    }


