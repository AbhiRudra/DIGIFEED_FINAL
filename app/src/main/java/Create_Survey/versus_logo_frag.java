package Create_Survey;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import static android.app.Activity.RESULT_OK;

public class versus_logo_frag extends Fragment
{

    public versus_logo_frag() {

    }

    View currentview;
    ArrayList<View> ViewStored=new ArrayList<>();
    LinearLayout linearLayout;
    View ret;
    ArrayList<String> tempq=new ArrayList<>();
    ArrayList<String> tempcont;
    Create_Survey.icomm icomm;
    Button submit;
    String[] uri1,uri2;
    Button b1,b2;
    Uri ur,ur1;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_IMAGE2 = 2;


    public void setTypeee(int typeee) {
        this.typeee = typeee;
    }

    int typeee;

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        ret= inflater.inflate(R.layout.versus_logo, container, false);
        linearLayout=ret.findViewById(R.id.linearcontainerradio);
        icomm=(icomm)getActivity();
        Log.d("tpeee", "onCreateView: "+typeee);


        submit=ret.findViewById(R.id.seek_submit);

          Button  b1=ret.findViewById(R.id.b1);
          Button  b2=ret.findViewById(R.id.b2);

           b1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                   photoPickerIntent.setType("image/*");
                   startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);
               }
           });

           b2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                   photoPickerIntent.setType("image/*");
                   startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE2);
               }
           });




           submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1=ret.findViewById(R.id.radio_edittext);



                if (!TextUtils.isEmpty(editText1.getText().toString()) ){

                    icomm.versuslogo(editText1.getText().toString(),ur,ur1);
                    try {
                        survey_creator survey_creator = new survey_creator();
                        // Log.d("naesss", "onClick: "+survey_creator.spkey);
                     }catch (Exception e){
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager=getFragmentManager();
                    Fragment fragment=fragmentManager.findFragmentById(R.id.linearcontainer);
                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                }



            }
        });






        return ret;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            ur=selectedImage;

        }

        if (requestCode == RESULT_LOAD_IMAGE2 && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            ur1=selectedImage;

        }



        }

    }

