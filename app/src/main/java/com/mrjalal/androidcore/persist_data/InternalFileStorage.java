package com.mrjalal.androidcore.persist_data;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by user on 4/7/2018.
 */

// https://developer.android.com/guide/topics/data/data-storage.html

public class InternalFileStorage {

    private Context context;

    public InternalFileStorage(Context context) {
        this.context = context;
    }

    public void saveFileInInternalFileStorage(String fileName, String fileContent) throws IOException {
        FileOutputStream outputStream;
        outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStream.write(fileContent.getBytes());
        outputStream.close();
    }

    public String readFileContentFromInternalFileStorage(String fileName) throws IOException {
        FileInputStream inputStream = context.openFileInput(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
