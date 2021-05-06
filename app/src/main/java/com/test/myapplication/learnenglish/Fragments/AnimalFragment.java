package com.test.myapplication.learnenglish.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.test.myapplication.learnenglish.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonDog, buttonCat, buttonLion, buttonMonkey, buttonSheep, buttonCow;

    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalFragment newInstance(String param1, String param2) {
        AnimalFragment fragment = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        buttonDog = view.findViewById(R.id.buttonDog);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonLion = view.findViewById(R.id.buttonLion);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonCow = view.findViewById(R.id.buttonCow);

        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonLion.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);
        buttonCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("Elemento clicado", "Item: " + v.getId() );
        switch (v.getId()) {
            case R.id.buttonDog :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                playSound();
                break;
            case R.id.buttonCat :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                playSound();
                break;
            case R.id.buttonLion :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                playSound();
                break;
            case R.id.buttonMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                playSound();
                break;
            case R.id.buttonSheep :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                playSound();
                break;
            case R.id.buttonCow :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                playSound();
                break;
        }
    }

    public void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}