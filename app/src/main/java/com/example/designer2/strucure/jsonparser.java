package com.example.designer2.strucure;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class jsonparser {

    static List<videoModel> videolist;


    public  static List<videoModel> parseData(String content){
        JSONArray jsonArray;
        videoModel model ;
        try{
            jsonArray = new JSONArray(content);
            videolist = new ArrayList<>();
            for (int i = 0; i< jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                model = new videoModel();
                model.setId(object.getInt("id"));
                model.setTitle(object.getString("title"));
                model.setDuration(object.getString("videoDuration"));
                model.setFeaturedimg(object.getString("featuredImage"));
                model.setViews(object.getString("videoViews"));
                model.setVideolink(object.getString("videoId"));
                videolist.add(model);






            }
            return videolist;


        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
