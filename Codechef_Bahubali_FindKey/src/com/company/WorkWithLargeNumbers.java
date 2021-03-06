package com.company;

import java.math.BigInteger;

public class WorkWithLargeNumbers {

    public static long numOfDigit(Long l){
        String str=new String(l.toString());
        return str.length();
    }

    public static long reverseLong(Long l){
        String str=new String(l.toString());
        String reverse=new StringBuffer(str).reverse().toString();
        Long ans=new Long(reverse);
        return ans;
    }



    public static void main(String[] args) {
        // write your code here

        //to find the number
        boolean prime=false;
        boolean clue2=false;
        boolean clue3=true;
        Long lowestPossible=142L*8L;
        BigInteger bgLowestPossible=new BigInteger(lowestPossible.toString());
        long i=0;
        for ( i=lowestPossible; i<99999999L;i=i+142){
            Long dn=numOfDigit(i);
            int dnInt=(int)numOfDigit(i);
            BigInteger bgDN=new BigInteger(dn.toString());
            Long rn=reverseLong(i);
            int rnInt=(int)reverseLong(i);
            BigInteger bgRN=new BigInteger(rn.toString());


            //Clue 1 : Checking
            //to check prime
            long num=(long)Math.pow(2,rn)-1;
            BigInteger bg2=new BigInteger("2");
            BigInteger bgNum=bg2.pow(rnInt);
            BigInteger bgNumFinal=bgNum.subtract(BigInteger.ONE);

            if (bgNumFinal.isProbablePrime(1)){
                prime=true;
            }

            //Clue 2 : Checking
            long num2=numOfDigit((long)bgNumFinal.toString().length());
            System.out.println("for "+i+" is "+bgNumFinal);

            if (numOfDigit(rn)==reverseLong(dn) && numOfDigit(rn)==num2){
                clue2=true;
            }


            //Clue 3 : Checking
            long lastDigit=num%10;
            char c=(char)lastDigit;
            Long I=i;
            String string=new String(I.toString());
            for (int j=0;j<string.length();j++){
                if (string.charAt(j)=='c'){
                    clue3=false;
                    break;
                }
            }

            System.out.println(i+" It's Prime check is--> "+prime+" It's clue2 check is--> "+clue2+" It's clue3 check is "+clue3);
//            if (clue2){
//                System.out.println("Found");
//                break;
//            }

            if (clue2 && clue3 && prime){
                System.out.println("Ans is "+i);
                System.out.println("Found");
//                break;
            }
        }
        System.out.println(i);
        System.out.println("Not Found");
        System.out.println("Max value is "+Long.MAX_VALUE);
    }
}
