package com.company;

import java.io.*;
import java.util.Scanner;

public class TakingEitherEvenOrOdd {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws java.lang.Exception{
        // write your code here
        try{
            Reader sc=new Reader();
            Scanner scanner=new Scanner(System.in);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            int t=sc.nextInt();
            while (t-->0){

                long grader=sc.nextLong();
                long ans=1;
                long max=grader;
                long min=0;
                long mid=(max+min)/2;
                long newMid=(max+min)/2;
                long newMax=0;
                long newMin=grader;


                for (int i=1;i<=1000000000;i++){
                    //Case when she speaks only odd number as truth
                    if (i%2==1){
                        //first answer will be true so
                        System.out.println(mid);
                        System.out.flush();
                        char trueEvenReply=sc.readLine().charAt(0);
                        if (trueEvenReply=='L'){
                            max=mid-1;
                            min=min;
                            mid=(max+min)/2;
                        }else if (trueEvenReply=='G'){
                            min=mid+1;
                            max=max;
                            mid=(max+min)/2;
                        }else if (trueEvenReply=='E'){
                            //We found it so break the loop
                            break;
                        }
                    }

                    //In Case if she is speaking the even questions truly
                    //Then we can continue with this too separately with separate mid and all stuffs
                    if (i%2==0){
                        //Second answer will be true
                        System.out.println(newMid);
                        System.out.flush();
                        char trueOddReply=sc.readLine().charAt(0);
                        if (trueOddReply=='L'){
                            newMax=newMid-1;
                            newMin=newMin;
                            newMid=(newMax+newMin)/2;
                        }else if (trueOddReply=='G'){
                            newMin=newMid+1;
                            newMax=newMax;
                            newMid=(newMax+newMin)/2;
                        }else if (trueOddReply=='E'){
                            //We found it so break the loop
                            break;
                        }
                    }
                }

            }

        }catch (Exception e){
            return;
        }
    }

}
