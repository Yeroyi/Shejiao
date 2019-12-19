package com.example.hongligs.http;

import java.io.IOException;

public interface NetCallBack {

    void onFailure(IOException e);

    void onResponse(String response, String type);
}
