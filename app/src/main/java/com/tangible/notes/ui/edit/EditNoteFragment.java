package com.tangible.notes.ui.edit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangible.notes.R;
import com.tangible.notes.ui.detail.DetailNoteFragment;

public class EditNoteFragment extends Fragment {

    private static final String ARG_NOTE_ID = "arg_note_id";
    private int noteId;

    public EditNoteFragment() {
        // Required empty public constructor
    }

    public static DetailNoteFragment newInstance(int param1) {
        DetailNoteFragment fragment = new DetailNoteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NOTE_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            noteId = getArguments().getInt(ARG_NOTE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_note, container, false);
    }
}