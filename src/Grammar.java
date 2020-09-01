import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Grammar {
    public ArrayList<Character> vn=new ArrayList<>();
    public ArrayList<Character> vt=new ArrayList<>();
    public Character s;
    public ArrayList<Prod> prod=new ArrayList<>();
    public void ReadFromFile(){
        try{
        Scanner file=new Scanner(new FileReader("grammar.txt"));
            String vn_s=file.nextLine();
            String vt_s=file.nextLine();
            s=file.nextLine().charAt(0);
            for(Character i:vn_s.toCharArray())
            {
                vn.add(i);
            }
            for(Character i:vt_s.toCharArray())
            {
                vt.add(i);
            }


            while(file.hasNextLine()){
               prod.add(new Prod());
               prod.get(prod.size()-1).AddLeft(file.next());
               prod.get(prod.size()-1).AddRight(file.next());

            }
    }catch(IOException e)
        {
            System.out.print("File not found");
        }
    }
    public boolean Validate() {
        boolean v1 =true, v2=true, v3 = true,v4=false,v5=false;

        int nrChar = 0;
        if (vn.size() > vt.size()) {
            for (Character i : vn) {
                if (vt.contains(i))
                    v1 = false;
            }

        } else {
            for (Character i : vt) {
                if (vn.contains(i))
                    v1 = false;
            }
        }
        if (!vn.contains(s))
            v2 = false;
        for (Prod i : prod) {
            for(Character j:i.left.toCharArray()){
                if(vn.contains(j)||vt.contains(j))
                    nrChar++;
                if(!vn.contains(j))
                    v3 = false;
                if (j.equals(s))
                    v4 = true;}
            if (nrChar == i.left.length()) {
                nrChar = 0;
                for (Character j : i.right.toCharArray()) {
                    if (vn.contains(j)||vt.contains(j))
                        nrChar++;
                }
                if (nrChar == i.right.length())
                    v5 = true;

            }
        }
        return v1 && v2 && v3 && v4 && v5;
    }

    public void Generate(boolean option)
    { String result=null;
      Random r=new Random();
      int randomInt=r.nextInt(prod.size()-1);
      boolean ok=true;
      while(!(prod.get(randomInt).left.charAt(0)==s))
          randomInt=r.nextInt(prod.size());
      result=prod.get(randomInt).right;
      if(option)
      System.out.print(prod.get(randomInt).left+"->"+result);
      int nrChar=0;
      while(ok) {
          nrChar=0;
          for(Character i:result.toCharArray())
          {
              if(vt.contains(i))
                  nrChar++;
          }
          if(nrChar!=result.length())
          {  randomInt=r.nextInt(prod.size());
          if(result.contains(prod.get(randomInt).left)){
          result=result.replace(prod.get(randomInt).left,prod.get(randomInt).right);
          if(option)
          System.out.print("->"+result);}
          }
          else
          ok=false;}
      if(!option)
         System.out.print(result);
    }

    }







