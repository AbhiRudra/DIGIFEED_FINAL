package Create_Survey;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import digifeed.com.digifeed_final.R;

public class survey_creator extends AppCompatActivity implements icomm {



    LinearLayout linearLayout = null;
    Dialog text_pop;
    Dialog pop;
    ArrayList<View> ViewStored=new ArrayList<>();
    ArrayList<String> tempq=new ArrayList<>();
    LinearLayout addquestions;
    LinearLayout linear;
    Dialog slider_pop;
    Dialog array_pop;
    Dialog question_type;
    TextView t1,t2;
    ImageButton type;

    Button add,remove;
    TextView noqustions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_creator);

        addquestions=findViewById(R.id.linearquestions);

        add=findViewById(R.id.addquestion);
        remove=findViewById(R.id.removequestion);
        noqustions=findViewById(R.id.numberquestions);

        inflateEditRow(null);



        linear=findViewById(R.id.questionaaa);
        type=findViewById(R.id.add);


        question_type=new Dialog(this);
        text_pop = new Dialog(this);
        pop = new Dialog(this);
        slider_pop = new Dialog(this);
        array_pop = new Dialog(this);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateEditRow(null);

            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });





    }

    private void inflateEditRow(String title) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.question, null);

        final ImageButton addtype= (ImageButton) rowView.findViewById(R.id.add);
        final TextView questionnumber= rowView.findViewById(R.id.questionNumber);
        final EditText question=rowView.findViewById(R.id.question);
        final ImageButton remove=rowView.findViewById(R.id.piping);

        question.setText(title);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addquestions.removeView((View) v.getParent());
                pop.dismiss();

            }
        });




        addquestions.addView(rowView, addquestions.getChildCount());



    }

    public void showpopup(View v){


        TextView check,radioa,dropdown,rating,emoji,array,textbox,nps,slider;
        final Spinner slide,versus;

        String val;
        pop.setContentView(R.layout.pop_array);

        check=pop.findViewById(R.id.checkbox);
        radioa=pop.findViewById(R.id.radio);
        dropdown=pop.findViewById(R.id.dropdown);
        rating=pop.findViewById(R.id.Rankings);
        emoji=pop.findViewById(R.id.emoji);
        array=pop.findViewById(R.id.array);
        textbox=pop.findViewById(R.id.textbox);
        nps=pop.findViewById(R.id.nps);
        slide=pop.findViewById(R.id.spinnera);
        versus=pop.findViewById(R.id.spinnerb);



        final radio_list_frag radio_list_frag = new radio_list_frag();
        final seekbar seekbar= new seekbar();
        final array_questions array_questions= new array_questions();
        final normal_slider_frag normal_slider_frag=new normal_slider_frag();
        final check_list_frag check_list_frag=new check_list_frag();
        final drop_list_frag drop_list_frag= new drop_list_frag();
        final rank_list_frag rank_list_frag= new rank_list_frag();
        final emoji_list_frag emoji_list_frag=new emoji_list_frag();
        final text_list_frag text_list_frag= new text_list_frag();
        final versus_text versus_text= new versus_text();
        final stra_rating_frag stra_rating_frag=new stra_rating_frag();
        final nps_frag nps_frag=new nps_frag();
        final versus_logo_frag versus_logo_frag=new versus_logo_frag();


        String[] types = new String[]{
                "Slider",
                "Normal",
                "Emoji",
                "Star Rating",
        };

        String[] typesa = new String[]{
                "Versus",
                "Text",
                "Logo",

        };

        final List<String> versuslist= new ArrayList<>(Arrays.asList(typesa));
        final List<String> sliderList = new ArrayList<>(Arrays.asList(types));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,sliderList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);


                return view;
            }
        };

        final ArrayAdapter<String> spinnerArrayAdaptera = new ArrayAdapter<String>(
                this,R.layout.spinner_item,versuslist){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);


                return view;
            }
        };

        spinnerArrayAdaptera.setDropDownViewResource(R.layout.spinner_item);


        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        slide.setAdapter(spinnerArrayAdapter);
        versus.setAdapter(spinnerArrayAdaptera);

        slide.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
               if(selectedItemText.equalsIgnoreCase("slider")){

               }

                if(selectedItemText.equalsIgnoreCase("Normal")){
                    fragmentListTrans(normal_slider_frag);
                    pop.dismiss();

                }
                else if(selectedItemText.equalsIgnoreCase("Emoji")){
                    fragmentListTrans(seekbar);
                    pop.dismiss();

                }
                else if(selectedItemText.equalsIgnoreCase("Star Rating")){
                    fragmentListTrans(stra_rating_frag);
                    pop.dismiss();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        versus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                if(selectedItemText.equalsIgnoreCase("versus")){

                }

                if(selectedItemText.equalsIgnoreCase("Text")){
                    fragmentListTrans(versus_text);
                    pop.dismiss();
                    linear.setVisibility(View.GONE);
                }
                else if(selectedItemText.equalsIgnoreCase("Logo")){
                    fragmentListTrans(versus_logo_frag);
                    pop.dismiss();
                    linear.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(rank_list_frag);
                pop.dismiss();

            }
        });

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(emoji_list_frag);
                pop.dismiss();

            }
        });

        nps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(nps_frag);
                pop.dismiss();

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(check_list_frag);
                pop.dismiss();

            }
        });

        radioa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(radio_list_frag);
                pop.dismiss();

            }
        });

        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(drop_list_frag);
                pop.dismiss();

            }
        });

        textbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(text_list_frag);
                pop.dismiss();

            }
        });

        array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListTrans(array_questions);
                pop.dismiss();

            }
        });

        Objects.requireNonNull(pop.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        Window window=pop.getWindow();
        window.setLayout(FrameLayout.LayoutParams.MATCH_PARENT, 700);


        pop.show();



    }









    private void fragmentListTrans(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.linearquestions, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void Question(String Question) {

    }

    @Override
    public void radio_list_choices(ArrayList<String> choices, String q) {

    }

    @Override
    public void arraydata(String questions, ArrayList<String> subQuestions) {

    }

    @Override
    public void versusdata(String question, String optiona, String optionb) {

    }

    @Override
    public void versuslogo(String question, Uri uri1, Uri uri2) {

    }



    @Override
    public void pipingdata(String question, ArrayList<String> subquestions, String sub, String sub1, int type, int qno) {

    }


    public  void delete (){
        try{

            addquestions.removeView(ViewStored.get(ViewStored.size()-1));
            ViewStored.remove(ViewStored.get(ViewStored.size()-1));
            tempq.remove(ViewStored.size()-1);

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("sizeofview2", "delete: "+ViewStored.size());
    }


    public void removequestion(View view) {

        addquestions.removeView((View) view.getParent());

    }
}
