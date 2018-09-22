package Create_Survey;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.util.ArrayList;

import Create_Survey.icomm;
import digifeed.com.digifeed_final.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class seekbar extends Fragment {

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


    public seekbar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ret =inflater.inflate(R.layout.fragment_seekbar, container, false);
linearLayout=ret.findViewById(R.id.linearcontainerradio);

        SeekBar seekBar=ret.findViewById(R.id.seekbarid);
        final EditText editText=ret.findViewById(R.id.radio_edittext);
        Button submit=ret.findViewById(R.id.seek_submit);

        seekBar.setThumb(getResources().getDrawable(R.drawable.sad));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("progress", "onProgressChanged: "+progress);
                Drawable drawable=null;

switch (progress){
    case 0:{
        drawable=getResources().getDrawable(R.drawable.saddest);
        seekBar.setThumb(drawable);
        break;
    }
    case 1:{
        drawable=getResources().getDrawable(R.drawable.sad);
        seekBar.setThumb(drawable);
        break;
}
    case 2:{
        drawable=getResources().getDrawable(R.drawable.neutral);
        seekBar.setThumb(drawable);
        break;
    }
    case  3:{
        drawable=getResources().getDrawable(R.drawable.happy);
        seekBar.setThumb(drawable);
        break;
    }
    case 4:{
        drawable=getResources().getDrawable(R.drawable.happiest);
        seekBar.setThumb(drawable);
        break;
    }
}

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
icomm=(icomm) getActivity();
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(!TextUtils.isEmpty(editText.getText().toString())){
          icomm.Question(editText.getText().toString());

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
