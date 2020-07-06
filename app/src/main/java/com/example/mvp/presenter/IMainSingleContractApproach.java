package com.example.mvp.presenter;

import com.example.mvp.model.interactors.IGetNextPriceInteractor;

/*Google recommends single contract approach for Model, View & Presenter*/
public interface IMainSingleContractApproach {

    //View
    interface IMainView {
        void showProgress();
        void hideProgress();
        void setPrice(String text);
    }

    //Presenter
    interface IMainPresenter {
        void onGetPriceClick();
        void onDestroy();
    }

    // Model
    interface IGetNextPriceInteractor{
        interface OnFinishedListener {
            void onFinished(String text);
        }

        void getNextPrice(OnFinishedListener onFinishedListener);
    }

}
