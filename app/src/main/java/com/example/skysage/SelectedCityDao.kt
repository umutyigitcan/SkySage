package com.example.skysage

class SelectedCityDao {
    fun changeData(vt:SelectedCity,cityName:String){

        var db=vt.writableDatabase
        db.execSQL("UPDATE selectedCity SET cityName='$cityName'")
        db.close()

    }

    fun getData(vt:SelectedCity):ArrayList<SelectedCityData>{

        var db=vt.writableDatabase
        var cursor=db.rawQuery("SELECT * FROM selectedCity",null)
        var list=ArrayList<SelectedCityData>()
        while (cursor.moveToNext()){
            var data=SelectedCityData(cursor.getString(cursor.getColumnIndexOrThrow("cityName")))
            list.add(data)
        }
        return list
    }

}