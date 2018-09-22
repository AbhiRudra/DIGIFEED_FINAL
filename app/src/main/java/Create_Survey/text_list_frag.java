package Create_Survey;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import Create_Survey.icomm;
import Create_Survey.survey_creator;
import digifeed.com.digifeed_final.R;

public class text_list_frag extends Fragment
{
    public text_list_frag() {

    }

    View currentview;
    ArrayList<View> ViewStored=new ArrayList<>();
    LinearLayout linearLayout;
    View ret;
    Button addbutton;
    ArrayList<String> tempq=new ArrayList<>();
    ArrayList<String> tempcont;
    Button remove;
    Create_Survey.icomm icomm;
    Button submit;

    public void setTypeee(int typeee) {
        this.typeee = typeee;
    }

    int typeee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ret= inflater.inflate(R.layout.fragment_text, container, false);
        linearLayout=ret.findViewById(R.id.linearcontainerradio);
        icomm=(icomm)getActivity();
        Log.d("tpeee", "onCreateView: "+typeee);


        submit=ret.findViewById(R.id.radio_submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1=ret.findViewById(R.id.radio_edittext);
                if (!TextUtils.isEmpty(editText1.getText().toString())){

                    icomm.Question(editText1.getText().toString());
                    try {
                        survey_creator survey_creator = new survey_creator();
                        // Log.d("naesss", "onClick: "+survey_creator.spkey);
                             }catch (Exception e){
                        e.printStackTrace();
                    }
                    android.app.FragmentManager fragmentManager=getFragmentManager();
                    Fragment fragment=fragmentManager.findFragmentById(R.id.linearcontainer);
                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                }



            }
        });






        return ret;

    }


}
