package com.kehuldroid.facedetection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ResultDialog extends DialogFragment {
    Button ok;
    TextView result;
    byte[] byteArray;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_resultdialog, container, false);
        String resultText = "";

        ok = view.findViewById(R.id.result_ok_button);
        result = view.findViewById(R.id.result_text_view);

        Bundle bundle = getArguments();
        resultText = bundle.getString(LCOFaceDetection.RESULT_TEXT);
        byteArray = bundle.getByteArray("image");

        result.setText(resultText);

        ok.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        dismiss();
                        Intent i = new Intent(getContext() , displayPhoto.class);
                        i.putExtra("image",byteArray);
                        startActivity(i);
                    }
                });
        return view;
    }
}

