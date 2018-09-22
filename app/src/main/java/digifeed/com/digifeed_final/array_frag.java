package digifeed.com.digifeed_final;


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
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class array_frag extends Fragment {


    View currentview;
    ArrayList<View> ViewStored=new ArrayList<>();
    LinearLayout linearLayout1;
    View ret;
    Button addbutton;
    ArrayList<String> sub_questions=new ArrayList<>();
    ArrayList<String> tempcont;
    Button remove;
    icomm icomm;
    int i=0;
    ImageView broos;
    View.OnFocusChangeListener onFocusChangeListener;
    Button submit;
EditText global;
    EditText global2=null;

    public array_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;

        view= inflater.inflate(R.layout.fragment_array_frag, container, false);
linearLayout1=view.findViewById(R.id.array_container);

addradioview();
addradioview();

global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);



       onFocusChangeListener=new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                addradioview();
//                broos=ViewStored.get(ViewStored.size()-2).findViewById(R.id.bross);
//                broos.setVisibility(View.VISIBLE);

//                broos=ViewStored.get(ViewStored.size()-1).findViewById(R.id.bross);
//                broos.setVisibility(View.GONE);

                global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);


            }
        };
//        global.setOnFocusChangeListener(onFocusChangeListener);
//global.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        if (hasFocus){
//            global.setOnFocusChangeListener(null);
//
//
//            global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
//        }
//    }
//});

        addbutton=view.findViewById(R.id.array_create);
       remove=view.findViewById(R.id.array_remove);
        submit=view.findViewById(R.id.array_submit);
        icomm=(icomm)getActivity();

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addradioview2();
            }
        });


        
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ViewStored.get(1)!=null) {
                    delete();
                }
            }
        });
        final EditText Main_Question=view.findViewById(R.id.array_edittext);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText last_question=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
//                sub_questions.add(last_question.getText().toString());

                if (!TextUtils.isEmpty(Main_Question.getText().toString())){

                    for (int i = 0; i <ViewStored.size() ; i++) {

                        EditText editText=ViewStored.get(i).findViewById(R.id.inf_ed);
                        if (TextUtils.isEmpty(editText.getText().toString())){
                            sub_questions.add(editText.getText().toString());
                        }


                    }

                    icomm.arraydata(Main_Question.getText().toString(),sub_questions);




                    android.app.FragmentManager fragmentManager=getFragmentManager();
                    assert fragmentManager != null;
                    Fragment fragment=fragmentManager.findFragmentById(R.id.linearcontainer);
                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                }
            }
        });


        return view;


    }


    public  void addradioview2(){
        EditText editText=null;
        try{

            if (!ViewStored.isEmpty()){
//                editText=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);

                global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
                Log.d("tempq", "addradioview2: "+sub_questions);
            }else {
                addradioview();
                Log.d("added", "addradioview2: "+sub_questions);
                Log.d("sizeofview", "delete: "+ViewStored.size());

            }



        }catch (Exception e){
            e.printStackTrace();
        }


        if (global!=null&&!TextUtils.isEmpty(global.getText().toString())){


//           sub_questions.add(editText.getText().toString());
            Log.d("tempqqq", "addradioview2: "+sub_questions);
            addradioview();
       }


    }

    public void addradioview(){
        try {
            LayoutInflater inflater = (LayoutInflater) Objects.requireNonNull(getActivity()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater!=null){
            currentview=inflater.inflate(R.layout.add_list,null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);



//            currentview = insertView();

            linearLayout1.addView(currentview);
            i=i+1;

            ViewStored.add(currentview);


                if (!ViewStored.isEmpty()){
//                editText=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
                    currentview.setTag(i);
                    Log.d("tagcurr", "addradioview: "+currentview.getTag());
                    broos=ViewStored.get(ViewStored.size()-1).findViewById(R.id.bross);

                    broos.setTag(i);
broos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {


//            Toast.makeText(getActivity(), v.getTag().toString(), Toast.LENGTH_SHORT).show();
            Log.d("clickedc", "onClick: " + "clicked");
            Log.d("tagid", "onClick: " + v.getTag().toString());

            for (int j = 0; j <ViewStored.size() ; j++) {
                Log.d("looplog", "onClick: "+"in loop");
View view=ViewStored.get(j);

                Log.d("ids", "onClick: "+view.getTag());
                Log.d("ids", "onClick: "+v.getId());
if ((view.getTag()!=null)) {
    Log.d("inif", "onClick: ");
    Log.d("gottag", "onClick: " + view.getTag().toString());
    if (view.getTag() == v.getTag()) {
        Log.d("matchedtag", "onClick: " + "matched");
        linearLayout1.removeView(view);
        ViewStored.remove(j);

        global=ViewStored.get(j-1).findViewById(R.id.inf_ed);
//       global.setOnFocusChangeListener(onFocusChangeListener);
break;


    }
}
            }
//            linearLayout1.getChildAt(linearLayout1.getChildCount()).setOnFocusChangeListener(onFocusChangeListener);

        }catch (Exception e){
            e.printStackTrace();
        }

//       View.OnFocusChangeListener onFocusChangeListener=new View.OnFocusChangeListener() {
//           @Override
//           public void onFocusChange(View view, boolean b) {
//
//               addradioview();
//

//
//
//           }
//       };

    }
});
//                    global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);

                    Log.d("tempq", "addradioview2: "+sub_questions);
                }else {

                    Log.d("added", "addradioview2: "+sub_questions);
                    Log.d("sizeofview", "delete: "+ViewStored.size());

                }








        }

//            global=ViewStored.get(ViewStored.size()-2).findViewById(R.id.inf_ed);

            if (global!=null){
                Log.d("nonnull", "addradioview: ");
                global.setOnFocusChangeListener(null);
                global=ViewStored.get(ViewStored.size()-1).findViewById(R.id.inf_ed);
                global.setOnFocusChangeListener(onFocusChangeListener);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

//    public LinearLayout insertView(){
//        final LinearLayout linearLayout = new LinearLayout(getActivity());
//        try {
//            int id = 0;
//            boolean run = false;
//            EditText editText = new EditText(getActivity());
//            editText.getId();
//
//            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//
//
//            final ImageView imageView = new ImageView(getActivity());
//            imageView.setImageDrawable(getResources().getDrawable(R.drawable.cross));
//
//            int comp=imageView.getId();
//            Log.d("comp", "insertView: "+comp);
//            if ((comp == -1)) {
//
//                i = i+1;
//                Log.d("ival", "insertView: " + i);
//                imageView.setId(i);
//
//
//            } else {
//                int ids = 1;
//                imageView.setId(ids);
//                Log.d("afterid", "insertView: "+imageView.getId());
//            }
//
//
//
//            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(100, 100);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            linearLayout.setLayoutParams(layoutParams);
//            imageView.setLayoutParams(layoutParams1);
//            editText.setLayoutParams(layoutParams2);
//
//            linearLayout.addView(editText);
//            linearLayout.addView(imageView);
//
//            ImageView imageView1=linearLayout.findViewById(i);
//
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return linearLayout;
//    }

    public  void delete (){
        Log.d("sizeofview", "delete: "+ViewStored.size());
        try{

    linearLayout1.removeView(ViewStored.get(ViewStored.size() - 1));
    ViewStored.remove(ViewStored.get(ViewStored.size() - 1));

            if(ViewStored.size()-1!=-1){
//                sub_questions.remove(ViewStored.size()-1);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("sizeofview2", "delete: "+ViewStored.size());
    }

}
