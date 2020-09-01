import java.util.ArrayList;

public class Prod {
     public String left="";
     public String right="";
     public void AddLeft(String ch){

            left=left+ch;
     }
     public void AddRight(String ch)
     {
         right=right+ch;
     }
     public String PrintProd()
     {
         return left+"->"+right;

     }
}
