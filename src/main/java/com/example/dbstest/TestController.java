package com.example.dbstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbstest.employe.EmployeDto;
import com.example.test.Tesla;
import com.example.test.Car;

import jakarta.validation.Valid;

@RestController
public class TestController {

    @CrossOrigin( origins="http://localhost:4200")
    @RequestMapping("/hello")
    public @ResponseBody MessageData hello(){
        Car t = new Tesla(4);
        System.out.println(t.getRoda());
        System.out.println(t.getBahanBakar());
        // System.out.println(t.test);
        return new MessageData("Hello");
    }   

    @CrossOrigin( origins="http://localhost:4200")
    @RequestMapping("/test4")
    public @ResponseBody MessageData test4(@Valid @RequestBody EmployeDto em ){
        System.out.println( em.getName() );
        return new MessageData("Hello");
    }   
    
    // SOAL TEST 1
    @RequestMapping("/test1")
    // public void test1(){
    public @ResponseBody MessageData test(@RequestParam("input") String input){
        // String input = "986234875324";
        System.out.println( input );
        int[] tmp = new int[input.length()];
        for(int i=0; i < input.length(); i++ ){
            tmp[i] = Character.getNumericValue(input.charAt(i));
        }

        for(int j=0; j < tmp.length; j++ ){
            // 0
            for(int jj=0; jj < tmp.length; jj++ ){
                // 6 ke - j = 2
                if( jj != ( tmp.length - 1 ) ){
                    //        2       6
                    if( tmp[jj+1] < tmp[jj] ){
                        int d = tmp[jj];
                        tmp[jj] = tmp[jj+1];
                        tmp[jj+1] = d;
                    }
                }
            }
        }

        for(int c=0; c < tmp.length; c++ ){
            System.out.print( tmp[c] );
        }

        return new MessageData("Hello");
    }

    // SOAL TEST 2
    @RequestMapping("/test2")
    // public void test2(){
    public @ResponseBody MessageData test2(@RequestParam("input") String input){
        HashMap<Integer, Integer> datas = new HashMap<Integer, Integer>();

        // String input = "986234875324";
        System.out.println( "input "+input );
        String[] tmp = new String[input.length()];
        for(int i=0; i < input.length(); i++ ){
            int tmpI = Character.getNumericValue(input.charAt(i));
            // System.out.println( tmpI+" ");
            
            // if( ! ( tmpI % 2 == 0) ){
                if( datas.isEmpty() ){
                    datas.put(tmpI, 1);
                } else {
                    if( datas.containsKey(tmpI) ){
                        datas.put(tmpI, datas.get(tmpI) + 1 );
                    } else {
                        datas.put(tmpI, 1);
                    }
                }
            // }
        }

        for( Entry<Integer, Integer> data : datas.entrySet() ) {
            System.out.println( data.getKey() +"-" + data.getValue()) ;  
        }

        return new MessageData(input);
    }

    // SOAL TEST 3
    @RequestMapping("/test3")
    public @ResponseBody MessageData test3(){
        String input = "James Bond Test asff ";
        String[] tmp = input.split(" ");
        String data = "";
        for(int i=0; i < tmp.length ; i++ ){
            data = data + tmp[ ( tmp.length - 1 ) - i ];
            if(  i < ( tmp.length - 1 ) ){
                data = data + " ";
            }
        }
        // String input = "asff Test Bond James";
        System.out.println( data );
        System.out.println( data.replaceAll(" ", " and ") );
        return new MessageData(input);
    }    


    @RequestMapping("/test5")
    public @ResponseBody MessageData test5(){
        String input = "JJames Bond Test ammsff ";
        char[] tmp  = input.toCharArray();
        int[] arr2 = new int[tmp.length];

        for(int i=0; i < tmp.length; i++ ){
            if( Character.isLetter(tmp[i]) ){
                for(int j=0; j < tmp.length; j++ ){
                    if( tmp[i] == tmp[j] ){
                        arr2[i] = arr2[i] + 1;
                    }
                }
            } else {
                arr2[i] = -1;
            }
           
        }

        String result = "";
        for(int x=0; x < arr2.length; x++ ){
            if( arr2[x] != -1 && arr2[x] == 1 ){
                result = String.valueOf( tmp[x] );
                break;
            }
        }
        return new MessageData(result);
    }

    @RequestMapping("/test6")
    public MessageData test6(){
        String input = "James Bond Test asff ";
        int[] test = new int[] {1, 5, 6, 7, 1, 2};

        // int[] test = new int[] {1, 5, 6, 7, 1, 2};
        int[] arr2 = new int[test.length];
        int count = test[0];
        int counter =0;

        for(int i=0; i < test.length; i++ ){
            arr2[i] = test[ (count + i ) % test.length ];
        }

        for(int x=0; x < arr2.length; x++ ){
            System.out.print( arr2[x]+" " );
        }

        System.err.println();
        System.out.println( test.length +" ");
        for(int i=0; i < test.length ; i++ ){
            System.out.println( i+" ");
            arr2[i] = test[ ( i+ count + (test.length - 1 ) ) % test.length ];
            counter += 1;
        }

        for(int x=0; x < arr2.length; x++ ){
            System.out.print( arr2[x]+" " );
        }

        return new MessageData( arr2.toString() );
    }

    @RequestMapping("/test7")
    public MessageData test7(){
        String[] input = new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        String[] tmp1 = input[0].split(",");
        String[] tmp2 = input[1].split(",");

        List<String> tmp3 = new ArrayList<String>();
        for(int i=0; i < tmp1.length; i++ ){
            for(int j=0; j < tmp2.length; j++ ){
                tmp1[i] = tmp1[i].replace(" ", "");
                tmp2[j] = tmp2[j].replace(" ", "");
                if( tmp1[i].equals(tmp2[j] ) ){
                    tmp3.add( tmp2[j] );
                }
            }
        }

        for(String show : tmp3 ){
            System.out.println( show );
        }

        return new MessageData( tmp3.get(0)+",,"+tmp3.get(tmp3.size()-1) );
    }

    @RequestMapping("/test8")
    public MessageData test8(@RequestParam("count")int countF,@RequestParam("input") String tmp){
        int count = countF;
        int countFinal  = ( count * 2 ) -2 ;
        System.out.println("FINAL "+countFinal );
        char[] data = tmp.toCharArray();
        for(int i=0; i < countF ; i++ ){
            int longc = ( count * 2 ) - 2;
            int longs = countFinal - longc;
            int countc = i;
            int counts = i;

            int jarak = 0;
            for( int j=0; j < data.length; j++){
                if( j == i ){
                    System.out.println("--> "+i+"-"+j+"-"+longc+"-"+longs+"-"+jarak+"-"+String.valueOf(data[j]) );
                }
                if( longc > 0 ){
                    if ( (j+i) == (longc * countc )) {
                        System.out.println("-c> "+i+"-"+j+"-"+longc+"-"+longs+"-"+jarak+"-"+ String.valueOf(data[j]) );
                        countc += 1;
                    }
                }
                if( longs > 0  ) {
                    if( (j+i) == (longs * counts) ){
                        System.out.println("-s> "+i+"-"+j+"-"+longc+"-"+longs+"-"+jarak+"-"+ String.valueOf(data[j]) );
                        counts += 1;
                    }
                } 
                System.out.println("--> "+i+"-"+j+"-"+longc+"-"+longs+"-"+jarak+"-");

                jarak += 1;
            }
            System.out.println("================="+i+"-"+longc+"-"+longs);
            count -=1 ;
        }

        return new MessageData( "" );
    }


    @RequestMapping("/test9")
    public void test9(@RequestParam("str") String str,@RequestParam("n") int n){
        // Corner Case (Only one row)
        String hasil = "";
        if (n == 1) 
        {
            System.out.print(str);
        }
        char[] str1 = str.toCharArray();
 
        // Find length of string
        int len = str.length();
 
        // Create an array of
        // strings for all n rows
        String[] arr = new String[n];
        Arrays.fill(arr, "");
 
        // Initialize index for
        // array of strings arr[]
        int row = 0;
        boolean down = true; // True if we are moving 
        // down in rows, else false
 
        // Traverse through
        // given string
        for (int i = 0; i < len; ++i) {
            // append current character
            // to current row
            arr[row] += (str1[i]);
            System.out.println(" "+arr[row]+" "+row+" "+n+" "+down );
            // If last row is reached,
            // change direction to 'up'
            if (row == n - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
 
            // If direction is down, 
            // increment, else decrement
            if (down){
                row++;
            } else{
                row--;
            }
        }
 
        // Print concatenation
        // of all rows
        for (int i = 0; i < n; ++i)  {
            hasil += arr[i];
        }
        System.out.println(hasil);
        System.out.println("=======================");
    }

}