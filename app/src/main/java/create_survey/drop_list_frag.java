package create_survey;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
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
import java.util.Objects;

import digifeed.com.digifeed_final.R;

public class drop_list_frag extends Fragment {

    public drop_list_frag() {


    }

    View currentview;
    ArrayList<View> ViewStored=new ArrayList<>();
    LinearLayout linearLayout;
    View ret;
    Button addbutton;
    ArrayList<String> tempq=new ArrayList<>();
    ArrayList<String> tempcont;
    Button remove;
    methods_interface methods_interface;
    Button submit;

    public void setTypeee(int typeee) {
        this.typeee = typeee;
    }

    int typeee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ret= inflater.inflate(R.layout.fragment_radio_list_frag, container, false);
        linearLayout=ret.findViewById(R.id.linearcontainerradio);
        addbutton=ret.findViewById(R.id.radio_create);
        methods_interface =(methods_interface)getActivity();
        Log.d("tpeee", "onCreateView: "+typeee);



        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addradioview2();
            }
        });
        remove=ret.findViewById(R.id.radio_remove);
        submit=ret.findViewById(R.id.radio_submit);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        typeee=3;


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
                EditText editText1=ret.findViewById(R.id.radio_edittext);
                tempq.add(editText.getText().toString());
                Log.d("tempqqq", "onClick: "+tempq);

                if (!TextUtils.isEmpty(editText1.getText().toString())){

//            methods_interface.radio_list_question(editText1.getText().toString());
                    methods_interface.option_questions(typeee,editText1.getText().toString(),tempq);
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


    public  void addradioview2(){
        EditText editText=null;
        try{

            if (!ViewStored.isEmpty()){
                editText=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);

                Log.d("tempq", "addradioview2: "+tempq);
            }else {
                addradioview();
                Log.d("added", "addradioview2: "+tempq);
                Log.d("sizeofview", "delete: "+ViewStored.size());

            }



        }catch (Exception e){
            e.printStackTrace();
        }


        if (editText!=null&&!TextUtils.isEmpty(editText.getText().toString())){


            tempq.add(editText.getText().toString());
            Log.d("tempqqq", "addradioview2: "+tempq);
            addradioview();
        }

    }

    public void addradioview(){
        LayoutInflater inflater = (LayoutInflater) Objects.requireNonNull(getActivity()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater!=null){
            currentview=inflater.inflate(R.layout.add_drop,null);
            linearLayout.addView(currentview);
            ViewStored.add(currentview);




        }


    }
    public  void delete (){
        Log.d("sizeofview", "delete: "+ViewStored.size());
        try{

            linearLayout.removeView(ViewStored.get(ViewStored.size()-1));
            ViewStored.remove(ViewStored.get(ViewStored.size()-1));
            tempq.remove(ViewStored.size()-1);

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("sizeofview2", "delete: "+ViewStored.size());
    }

}
