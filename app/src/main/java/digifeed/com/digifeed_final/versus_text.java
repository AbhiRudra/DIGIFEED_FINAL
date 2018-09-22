package digifeed.com.digifeed_final;

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

public class versus_text extends Fragment {

    public versus_text() {

    }

    View currentview;
    ArrayList<View> ViewStored=new ArrayList<>();
    LinearLayout linearLayout;
    View ret;
    Button addbutton;
    ArrayList<String> tempq=new ArrayList<>();
    ArrayList<String> tempcont;
    Button remove;
    icomm icomm;
    Button submit;

    public void setTypeee(int typeee) {
        this.typeee = typeee;
    }

    int typeee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ret= inflater.inflate(R.layout.fragment_versus_text, container, false);
        linearLayout=ret.findViewById(R.id.linearcontainerradio);
        icomm=(icomm)getActivity();
        Log.d("tpeee", "onCreateView: "+typeee);


        submit=ret.findViewById(R.id.radio_submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1=ret.findViewById(R.id.radio_edittext);
                EditText edittext2=ret.findViewById(R.id.option1_edittext);
                EditText edittext3=ret.findViewById(R.id.option2_edittext);

                if (!TextUtils.isEmpty(editText1.getText().toString()) && !TextUtils.isEmpty(edittext2.getText().toString()) && !TextUtils.isEmpty(edittext3.getText().toString())){

                    icomm.versusdata(editText1.getText().toString(),edittext2.getText().toString(),edittext3.getText().toString());
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
