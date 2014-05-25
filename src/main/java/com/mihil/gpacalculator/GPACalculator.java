/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mihil.gpacalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihil
 */
public class GPACalculator {

    static Logger gpaLog =  Logger.getLogger(GPACalculator.class.getName());
    public static void main(String[] args) {
        System.out.println("****************************************************************************");
        System.out.println("*  University of Moratuwa - Department of Computer Science and Engineering *");
        System.out.println("*                                                                          *");
        System.out.println("*                       Semester GPA Calculator                            *");
        System.out.println("*                                                                          *");
        System.out.println("*              "+String.valueOf('\u00A9')+"  Mihil Chathuranga Samarawickrama Ranathunga              *");
        System.out.println("***************************************************");
        System.out.println("Enter subject credit,result sperated by spaces");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = null;
        try {
            result = br.readLine();
        } catch (IOException ex) {
            gpaLog.log(Level.SEVERE," Error reading String", ex);
        }
        String [] creditGPA  = null;
        if(!result.equals(null)){
            creditGPA = result.split(" ");
        }
        float totalcredits =0;
        float totalmarks =0;//GPA*credit
        HashMap<String, Float> credits;
        credits = new HashMap<String,Float>(){{
            put("a+", new Float(4.2));
            put("a", new Float(4.0));
            put("a-", new Float(3.7));
            put("b+", new Float(3.3));
            put("b", new Float(3.0));
            put("b-", new Float(2.7));
            put("c+", new Float(2.3));
            put("c", new Float(2.0));
            put("c-", new Float(1.5));
            put("d", new Float(1.0));
                   
        }};
        
        if(creditGPA!= null){
            for(String s : creditGPA){
                String [] marks = s.split(",");
                float credit = Float.parseFloat(marks[0]);
                float mark = credits.get(marks[1].toLowerCase());
                
                totalcredits = totalcredits + credit;
                gpaLog.log(Level.FINE,"Total credits : "+totalcredits);
                totalmarks = totalmarks+credit*mark;
                gpaLog.log(Level.FINE,"Total marks : "+totalmarks);
  
            }
            gpaLog.log(Level.INFO,"SGPA : "+totalmarks/totalcredits);    
        }


    }
    
}
