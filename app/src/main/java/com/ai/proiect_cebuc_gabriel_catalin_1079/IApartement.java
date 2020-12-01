package com.ai.proiect_cebuc_gabriel_catalin_1079;

import java.util.ArrayList;

public interface IApartement {
    void onSucces(ArrayList<Apartemnte> apartemntes);
    void onFailure(int errorCode, Throwable error);
}
