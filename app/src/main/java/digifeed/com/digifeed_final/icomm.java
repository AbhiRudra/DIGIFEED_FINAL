package digifeed.com.digifeed_final;

import android.net.Uri;

import java.net.URI;
import java.util.ArrayList;

public interface icomm {

   void Question(String Question);
   void radio_list_choices(ArrayList<String> choices, String q);
   void arraydata(String questions, ArrayList<String> subQuestions);
   void versusdata(String question, String optiona, String optionb);
   void versuslogo(String question, Uri uri1, Uri uri2);
   void pipingdata(String question, ArrayList<String> subquestions, String sub, String sub1, int type, int qno);

}
