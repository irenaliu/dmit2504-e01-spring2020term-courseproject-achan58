package ca.nait.dmit2504.soundboardapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class HomeFragment extends Fragment {

    private MainActivityViewModel mMainActivityViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
        

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        // Load default audio clips to launchpad
        loadDefaultAudio();

        // getViewLifecycleOwner instead of this so that the observer is not bound to the instance of the fragment, allowing it to be unbound when fragment view is destroyed
        mMainActivityViewModel.getAudioClips().observe(getViewLifecycleOwner(), new Observer<List<AudioClip>>() {
            @Override
            public void onChanged(List<AudioClip> audioClips) {
                // refresh launchpad_button-audio bind
            }
        });
    }

    public void loadDefaultAudio() {

    }
}