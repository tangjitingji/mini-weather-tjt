package com.example.tangjiting.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.tangjiting.bean.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjiting on 2017/11/1.
 */

public class CityDB {
    public static final String CITY_DB_NAME = "city.db";
    private static final String CITY_TABLE_NAME = "city";
    private static final String city = "city";
    private static final String province = "province";
    private static final String allpy = "allpy";
    private static final String allfirstpy = "allfirstpy";
    //private static final String firstpy = "firstpy";
    private SQLiteDatabase db;

    public CityDB(Context context, String path) {
        db = context.openOrCreateDatabase(path, Context.MODE_PRIVATE, null);
    }
    public List<City> getAllCity() {
        List<City> list = new ArrayList<City>();
        Cursor c = db.rawQuery("SELECT * from " + CITY_TABLE_NAME, null);
        while (c.moveToNext()) {
            int _id=c.getInt(c.getColumnIndex("_id"));
            String province = c.getString(c.getColumnIndex("province"));
            String city = c.getString(c.getColumnIndex("city"));
            String number = c.getString(c.getColumnIndex("number"));
            String allPY = c.getString(c.getColumnIndex("allpy"));
            String allFirstPY = c.getString(c.getColumnIndex("allfirstpy"));
            String firstPY = c.getString(c.getColumnIndex("firstpy"));
            City item = new City(_id,province, city, number, firstPY, allPY,allFirstPY);
            list.add(item);
        }
        return list;
    }

    //得到筛选后的城市数据
    public List<City> getSelectCity(CharSequence key){
        Log.d("MyAPP",key.toString());
        List<City> list = new ArrayList<>();
        Cursor cursor=null;
        if (null != key && !"".equals(key)) {
            //查询的列字段名
            String [] columns = {"*"};
            //查询条件
            String where = province+ " like ? or "+ city+ " like ? or "+allpy+" like ? or "+allfirstpy+" like ? ";
            //查询参数
            String [] selectArgs = {key+"%" , key+"%" , key+"%"};
            //执行查询
            cursor = db.query(CITY_TABLE_NAME, columns, where , selectArgs, null, null, null);


            while (cursor.moveToNext()) {
                int _id=cursor.getInt(cursor.getColumnIndex("_id"));
                String province=cursor.getString(cursor.getColumnIndex("province"));
                String city=cursor.getString(cursor.getColumnIndex("city"));
                String number=cursor.getString(cursor.getColumnIndex("number"));
                String allPY=cursor.getString(cursor.getColumnIndex("allpy"));
                String allFirstPY=cursor.getString(cursor.getColumnIndex("allfirstpy"));
                String firstPY=cursor.getString(cursor.getColumnIndex("firstpy"));
                City item=new City(_id,province,city,number,firstPY,allPY,allFirstPY);
                list.add(item);

            }
        }
        cursor.close();

        return  list;
    }
}
