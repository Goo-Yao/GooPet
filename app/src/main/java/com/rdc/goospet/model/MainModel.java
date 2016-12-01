package com.rdc.goospet.model;

import com.rdc.goospet.R;
import com.rdc.goospet.entity.PetInfo;
import com.rdc.goospet.model.minterface.MainMInterface;
import com.rdc.goospet.utils.AppConstants;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-9-18.
 */
public class MainModel implements MainMInterface {
    @Override
    public ArrayList<PetInfo> getPetData() {
        ArrayList<PetInfo> data = new ArrayList<>();
        data.add(new PetInfo(AppConstants.PET_OWL, "Bean", "A sleepless owl", R.drawable.pic_owl_main, false));
        data.add(new PetInfo(AppConstants.PET_PIG, "Karo", "A lovely pig", R.drawable.pic_pig_main, false));
        data.add(new PetInfo(AppConstants.PET_COW, "Abbi", "A docile cow", R.drawable.pic_cow_main, false));
        data.add(new PetInfo(AppConstants.PET_BIRD, "Pear", "A cute bird", R.drawable.pic_bird_main, false));
        return data;
    }
}
