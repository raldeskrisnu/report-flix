package com.clue.raldeskrisnu.clue.presenter;

import com.clue.raldeskrisnu.clue.models.ResultApi;

import java.util.List;

public interface MainViewInterface {

    void displayData(List<ResultApi> resultApi);
    void showToast(String str);
    void displayError(String str);
}
