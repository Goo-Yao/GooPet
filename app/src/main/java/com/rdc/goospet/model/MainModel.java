package com.rdc.goospet.model;

import com.rdc.goospet.R;
import com.rdc.goospet.entity.PetInfo;
import com.rdc.goospet.model.minterface.MainMInterface;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-9-18.
 */
public class MainModel implements MainMInterface {
    @Override
    public ArrayList<PetInfo> getPetData() {
        ArrayList<PetInfo> data = new ArrayList<>();
        data.add(new PetInfo("Pika", "A pet named Pika from USA","#FBC02D", R.drawable.ic_face_01, false));
        data.add(new PetInfo("Karo", "A pet named Karo from Japan","#3F51B5", R.drawable.ic_face_02, false));
        data.add(new PetInfo("Bean", "A pet named Bean from China","#8BC34A", R.drawable.ic_face_03, false));
        data.add(new PetInfo("Spark", "A pet named Spark from UK","#F44336", R.drawable.ic_face_04, false));
        data.add(new PetInfo("Buddy", "A pet named Buddy from SW","#9C27B0", R.drawable.ic_face_05, false));
        return data;
    }
}
