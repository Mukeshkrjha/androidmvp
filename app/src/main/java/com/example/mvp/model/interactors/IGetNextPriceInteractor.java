package com.example.mvp.model.interactors;

public interface IGetNextPriceInteractor {

    interface OnFinishedListener {
        void onFinished(String text);
    }

    void getNextPrice(OnFinishedListener onFinishedListener);
}
