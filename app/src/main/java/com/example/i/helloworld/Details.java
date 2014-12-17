package com.example.i.helloworld;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by i on 17.12.14.
 */
public class Details implements KvmSerializable{
    private String mBezeichnung;
    private String mBIC;
    private String mPLZ;
    private String mOrt;

    @Override
    public Object getProperty(int index)
    {
        switch (index)
        {
            case 0:
                return mBezeichnung;
            case 1:
                return mBIC;
            case 2:
                return mPLZ;
            default:
                return mOrt;
        }
    }

    @Override
    public int getPropertyCount()
    {
        return 4;
    }

    @Override
    public void getPropertyInfo(int index, Hashtable table, PropertyInfo info)
    {
        switch (index)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "bezeichnung";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "bic";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "plz";
                break;
            default:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "ort";
                break;
        }
    }

    @Override
    public void setProperty(int index, Object value)
    {
        switch (index)
        {
            case 0:
                mBezeichnung = (String)value;
                break;
            case 1:
                mBIC = (String)value;
                break;
            case 2:
                mPLZ = (String)value;
                break;
            default:
                mOrt = (String)value;
                break;
        }
    }
}
