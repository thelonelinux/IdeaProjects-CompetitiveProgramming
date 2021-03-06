package com.company;

import java.io.*;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class ConsecutiveSameMeansTrue {

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
                long max=grader;
                long min=0;
                long mid=(max+min)/2;
                char firstReply='A';

                //First just ask the question and store the value
                //if two consecutive replies are same then he is speaking true;
                System.out.println(mid);
                System.out.flush();
                firstReply=sc.readLine().charAt(0);
                //store this value to be compared with the next in the same question
                char storedValue=firstReply;
                if (storedValue=='E'){
                    continue;
                }


                for (int i=1;i<=100000;i++){
                    //Case when she speaks only odd number as truth

                        //first answer will be true so
                        System.out.println(mid);
                        System.out.flush();
                        char Reply=sc.readLine().charAt(0);
                        if (Reply=='E'){
                            break;
                        }
                        if (storedValue==Reply){
                            //So we got two consecutive values
                            //Means he is saying the truth
                            // Modify mid for next time to ask;
                            storedValue='A';
                            if (Reply=='L'){
                                max=mid-1;
                                min=min;
                                mid=(max+min)/2;
                            }else if (Reply=='G'){
                                min=mid+1;
                                max=max;
                                mid=(max+min)/2;
                            }
                        }else{
                            //If stored value is not same as reply
                            //store this new value
                            //and again ask for same mid value only until we get consecutives
                            storedValue=Reply;
                        }
                }

            }

        }catch (Exception e){
            return;
        }
    }

}
